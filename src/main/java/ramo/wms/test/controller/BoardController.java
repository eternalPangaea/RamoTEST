package ramo.wms.test.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.thymeleaf.util.StringUtils;
import ramo.wms.test.domain.*;
import ramo.wms.test.service.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@EnableTransactionManagement
@RequestMapping("/board")
public class BoardController {

    @Autowired
    private B_shownameService b_shownameService;
    @Autowired
    private B_defService b_defService;
    @Autowired
    private S_whs_statusService s_whs_statusService;
    @Autowired
    private S_whs_recordService s_whs_recordService;
    @Autowired
    private B_unittype_defService b_unittype_defService;
    @Autowired
    private S_matl_statusService s_matl_statusService;
    @Autowired
    private E_wh_structureService e_wh_structureService;

    //用户动态建看板显示表，表名用b_show_拼接上仓库id
    @RequestMapping(value = "/createb",  method = RequestMethod.POST)
    public Map<String, String> creatB(@RequestBody Map<String, String> param) throws MyException{
        if(!param.containsKey("wh_id") || param.get("wh_id").equals(""))
            throw new MyException("系统繁忙");
        //拼接表名,然后去建表
        String table_name = "b_show_".concat(param.get("wh_id"));
        int t = b_shownameService.create(table_name);
        //在b_showname表中记录下看板显示表表名
        B_showname b = new B_showname();
        b.setName(table_name);
        b_shownameService.add(b);
        Map<String, String> map = new HashMap<>();
        if(t==0){
            map.put("status","1");
            map.put("message","新建成功");
            return map;
        }
        else
            throw new MyException("系统繁忙！");

    }

    //用户动态删表
    @RequestMapping(value = "dropb", method = RequestMethod.POST)
    public Map<String, String> dropB(@RequestBody Map<String, String> param) throws MyException{
        if(!param.containsKey("wh_id") || param.get("wh_id").equals(""))
            throw new MyException("系统繁忙");
        //拼接表名，并删除该表
        String table_name = "b_show_".concat(param.get("wh_id"));
        int t = b_shownameService.drop(table_name);
        //在b_showname表中删除看板显示表表名
        b_shownameService.delete(table_name);
        Map<String, String> map = new HashMap<>();
        if(t==0){
            map.put("status","1");
            map.put("message","删除成功");
            return map;
        }
        else
            throw new MyException("系统繁忙！");
    }

    //！！！！！发给前端所有的看板的b_id和b_name以及看板单元定义表
    @RequestMapping(value = "/allboards", method = RequestMethod.GET)
    public Map<String, List<Map<String,String>>> allboard(){
        Map<String,List<Map<String,String>>> result = new HashMap<>();
        //获取所有的看板id和看板名称
        List<Map<String, String>> temp1  = b_defService.allidname();
        result.put("b_info", temp1);
        //获取所有的看板单元定义
        List<Map<String, String>> temp2 = b_unittype_defService.all();
        result.put("b_unit_typeinfo", temp2);
        return result;
    }


    //！！！！！根据前端发来看板id传送对应的看板显示表
    @RequestMapping(value = "/chooseboard", method = RequestMethod.POST)
    public Map<String, List<Map<String,String>>> chooseBoard(@RequestBody Map<String, String> param) throws MyException{
        if(!param.containsKey("b_id") || param.get("b_id").equals(""))
            throw new MyException("看板id不可为空");
        Map<String,List<Map<String,String>>> result = new HashMap<>();
        B_def b =  b_defService.findbyid(Integer.parseInt(param.get("b_id")));
        String b_showname = b.getB_showname();
        List<Map<String,String>> map = new ArrayList<>();
        Map<String, String> temp2 = new HashMap<>();
        //加背景图和分辨率以及真实坐标
        temp2.put("bg_pic", b.getBg_pic());
        temp2.put("bg_real_location1", b.getReal_location1());
        temp2.put("bg_real_location2", b.getReal_location2());
        temp2.put("resolution", b.getResolution());
        map.add(temp2);
        result.put("b_bg",map);
        //根据看表显示表名，获取该表的内容，存放到变量List里
        List<Map<String,String>> List = b_shownameService.findbytlname(b_showname);
        result.put("b_show",List);
        return result;
    }


    //根据传来的仓位id，进行仓位锁定
    @RequestMapping(value = "/lockwhs", method = RequestMethod.POST)
    public Map<String,String> lockWhs(@RequestBody Map<String,String> param) throws MyException{
        if(!param.containsKey("whs_id") || !param.containsKey("logintl_id") || param.get("whs_id").equals("") || param.get("logintl_id").equals(""))
            throw new MyException("请输入有效的仓位id或者加锁者id");
        int t = s_whs_statusService.updatelock(param.get("logintl_id"), param.get("whs_id"));
        Map<String, String> map = new HashMap<>();
        if(t==1){
            map.put("status","1");
            map.put("message","锁定成功");
            return map;
        }
        else
            throw new MyException("锁定失败");
    }

    //根据传来的仓位id，进行仓位解锁
    @RequestMapping(value = "/unlockwhs", method = RequestMethod.POST)
    public Map<String,String> unlockWhs(@RequestBody Map<String,String> param) throws MyException{
        if(!param.containsKey("whs_id") || param.get("whs_id").equals(""))
            throw new MyException("请输入有效的仓位id或者加锁者id");
        int t = s_whs_statusService.unlock(param.get("whs_id"));
        Map<String, String> map = new HashMap<>();
        if(t==1){
            map.put("status","1");
            map.put("message","解锁成功");
            return map;
        }
        else
            throw new MyException("解锁失败");
    }


    //根据物品ID和它的仓位执行物品锁定
    @RequestMapping(value = "/lockmatl", method = RequestMethod.POST)
    public Map<String, String> lockMatl(@RequestBody Map<String, String> param) throws MyException{
        if(!param.containsKey("logintl_id") || !param.containsKey("matl_id") || !param.containsKey("whs_id") || param.get("logintl_id").equals("") || param.get("matl_id").equals("") || param.get("whs_id").equals(""))
            throw new MyException("仓位id或者物品id或者加锁者id缺失");
        int t = s_whs_recordService.lockmatl(param.get("whs_id"), param.get("matl_id"), param.get("logintl_id"));
        Map<String, String> map = new HashMap<>();
        if(t == 1){
            map.put("status", "1");
            map.put("message", "加锁成功");
            return map;
        }
        else
            throw new MyException("加锁失败");
    }

    //根据物品ID和它的仓位执行物品解锁
    @RequestMapping(value = "/unlockmatl", method = RequestMethod.POST)
    public Map<String, String> unlockMatl(@RequestBody Map<String, String> param) throws MyException{
        if(!param.containsKey("whs_id") || !param.containsKey("matl_id") || param.get("matl_id").equals("") || param.get("whs_id").equals(""))
            throw new MyException("仓位id或者物品id缺失");
        int t = s_whs_recordService.unlockmatl(param.get("whs_id"), param.get("matl_id"));
        Map<String, String> map = new HashMap<>();
        if(t == 1){
            map.put("status", "1");
            map.put("message", "解锁成功");
            return map;
        } 
        else
            throw new MyException("解锁失败");
    }

    //看板里查看仓位存放内容以及信息
    @RequestMapping(value = "/whsinfo", method = RequestMethod.POST)
    public List<S_whs_record> whsInfo(@RequestBody Map<String, String> param) throws MyException{
        if(!param.containsKey("whs_id") || param.get("whs_id").equals(""))
            throw new MyException("请输入有效的仓位id");
        return s_whs_recordService.findBywhsid(param.get("whs_id"));
    }

    //获取所有物品状态码列表，前端一加载就用ajax方式获取
    @RequestMapping(value = "/whsstatus", method = RequestMethod.GET)
    public List<S_matl_status> whsStatus(){
        return s_matl_statusService.all();
    }


    //看板上悬浮窗口的接口（显示该仓库里所有仓位以及仓位上存放的物品以及数量，批次号）
    @RequestMapping(value="/xuanfu", method = RequestMethod.POST)
    public List<Map<String, String>> Xuanfu(@RequestBody Map<String, String> param) throws MyException{
        if(!param.containsKey("b_id") || param.get("b_id").equals(""))
            throw new MyException("看板id缺失");
        B_def b =  b_defService.findbyid(Integer.parseInt(param.get("b_id")));
        if(b == null)
            throw new MyException("看板id有问题");
        String b_showname = b.getB_showname();
        String parent = StringUtils.substringAfter(b_showname,"w_");
        return e_wh_structureService.findByparent(parent);
    }

}
