package ramo.wms.test.controller;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ramo.wms.test.domain.*;
import ramo.wms.test.service.*;

import java.util.*;

@RestController
@EnableTransactionManagement
@RequestMapping(value = "/task")
public class TaskController {
    @Autowired
    private T_nowService t_nowService;
    @Autowired
    private T_typeService t_typeService;
    @Autowired
    private E_loginService e_loginService;
    @Autowired
    private E_matl_structure1Service e_matl_structure1Service;
//    @Autowired
//    private E_matl_defService e_matl_defService;
    @Autowired
    private S_whs_recordService s_whs_recordService;
    @Autowired
    private E_dept_categoryService e_dept_categoryService;
    @Autowired
    private E_wh_structureService e_wh_structureService;
    @Autowired
    private S_whs_statusService s_whs_statusService;
    @Autowired
    private T_statusService t_statusService;


    //调出所有创建人是该用户以及任务对象是该用户的任务
    @ApiOperation(value="获取任务列表", notes="根据传入的用户id，查找任务创建者和执行者等于该用户id的任务")
    //@ApiImplicitParam(name = "logintl_id",value = "用户id",required = true,dataType = "String")
    @RequestMapping(value = "/list", method=RequestMethod.POST)
    public List<T_now> findBycreator(@RequestBody Map<String, String> map) throws MyException{
        if(!map.containsKey("logintl_id") || map.get("logintl_id").equals("")){
            throw new MyException("logintl_id不可为空");}
        else
            return t_nowService.findCreatorObject(map.get("logintl_id"), map.get("logintl_id"));
    }


    //调出所有的任务类型
    @ApiOperation(value="获取任务类型定义列表")
    @RequestMapping(value= "/typelist",method=RequestMethod.GET)
    public List<T_type> allTasktype(){
        return t_typeService.all();
    }


    //返回指定权限下的物品目录及物品
    @ApiOperation(value="获取物品及其目录列表", notes="根据传入的用户id，查找该用户id对应的角色权限id，再根据角色权限id查找该权限下的所有物品以及物品目录")
    @ApiImplicitParam(name = "logintl_id",value = "用户id",required = true,dataType = "String")
    @RequestMapping(value = "/matlstruct",method=RequestMethod.POST)
    public List<E_matl_structure1> malStruct(@RequestBody Map<String, String> map) throws MyException{
        if(!map.containsKey("logintl_id") || map.get("logintl_id").equals(""))
            throw new MyException("logintl_id不可为空");
        int logintl_id = Integer.parseInt(map.get("logintl_id"));
        int ch_ids = e_loginService.findChid(logintl_id);
        return e_matl_structure1Service.findBychid(String.valueOf(ch_ids));
    }

    /*
    //根据物品目录，返回该目录下的物品,这个暂时不用
    @ApiOperation(value="获取物品列表", notes="根据传入的物品目录id，查找该目录下的所有物品")
    @ApiImplicitParam(name = "matl_structname",value = "物品目录名称",required = true,dataType = "String")
    @RequestMapping("/authmatl")
    public List<E_matl_def> authMatl(@RequestBody String matl_structname) throws MyException{
        if(matl_structname == null || matl_structname == "")
            throw new MyException("matl_structname不可为空");
        List<E_matl_def> List = e_matl_defService.findByparent(matl_structname);
        return List;
    }
    */

    //根据物品id查找其所在的仓位
    @ApiOperation(value="获取物品所在的仓位列表", notes="根据传入的物品id，查找该存放该物品的所有仓位")
    @ApiImplicitParam(name = "matl_id",value = "物品id",required = true,dataType = "String")
    @RequestMapping(value = "/findwhsbymatl",method=RequestMethod.POST)
    public List<S_whs_record> findWhsbymatl(@RequestBody Map<String, String> map) throws MyException{
        if(!map.containsKey("matl_id") || map.get("matl_id").equals(""))
            throw new MyException("matl_id不可为空");
        return s_whs_recordService.findBymatlidNolock(map.get("matl_id"));
    }


    //根据logintl_id查询其所属部门下的下属部门
    @ApiOperation(value="获取下属部门列表", notes="根据传入的用户id，查找该用户所在的部门，然后查找该部门的所有下属部门")
    @ApiImplicitParam(name = "logintl_id",value = "用户id",required = true,dataType = "String")
    @RequestMapping(value = "/findsubdept", method = RequestMethod.POST)
    public List<E_dept_category> findSubdept(@RequestBody Map<String, String> map) throws MyException{
        if(!map.containsKey("logintl_id") || map.get("logintl_id").equals(""))
            throw new MyException("logintl_id不可为空");
        int id = Integer.parseInt(map.get("logintl_id"));
        int dept_id = e_loginService.findDeptid(id);
        String subdept_ids = e_dept_categoryService.findSubdept(dept_id);
        return e_dept_categoryService.findBysubdept(subdept_ids);
    }


    //根据dept_id查询该部门下所有员工
    @ApiOperation(value="获取员工列表", notes="根据传入的部门id，查找该部门下所有员工，返回他们的用户id，用户名和昵称")
    @ApiImplicitParam(name = "dept_id",value = "部门id",required = true,dataType = "String")
    @RequestMapping(value = "/findemployees", method = RequestMethod.POST)
    public List<Map<String,String>> findEmployees(@RequestBody Map<String, String> map) throws MyException{
        if(!map.containsKey("dept_id") || map.get("dept_id").equals(""))
            throw new MyException("部门id不可为空");
        int dept_id = Integer.parseInt(map.get("dept_id"));
        return e_loginService.findBydept(dept_id);
    }


    //调出仓库结构表的结构
    @ApiOperation(value="获取仓库组织列表", notes="获取所有的仓库，工厂，库区以及未上锁的仓位（没有叉车）")
    @RequestMapping(value = "/findwhstructure", method = RequestMethod.GET)
    public List<E_wh_structure> findWhsstructure(){
        List <E_wh_structure> List = new ArrayList<>();
        List.addAll(e_wh_structureService.allwh());
        List.addAll(e_wh_structureService.allwhnolock());
        return List;
    }


    //调用所有没有上锁的仓位状态
    @ApiOperation(value="获取所有未上锁的仓位列表", notes="返回内容有whs_id(仓位),whs_infoid（仓位说明）,whs_allvol（仓位总容积）,whs_availvol（当前可以容积）,percent（可用容积百分比）")
    @RequestMapping(value = "/whsstatus", method = RequestMethod.GET)
    public List<Map<String,String>> whsStatus(){
         return s_whs_statusService.findNowhslock();
    }


    //上传一个新任务
    @ApiOperation(value="创建任务", notes="根据任务对象创建一个新任务，其创建时间（t_ctime）由后台自动生成")
    @ApiImplicitParam(name = "t_now",value = "任务详细实体t_now",required = true,dataType = "T_now")
    @RequestMapping(value= "/newtask", method = RequestMethod.POST)
    public Map<String, String> newTask(@RequestBody T_now t_now) throws MyException{
            if(t_now.getT_id()==null)
                throw new MyException("任务号不可为空呦");
            int t = t_nowService.add(t_now);
            Map<String, String> map = new HashMap<>();
            if(t==1){
                map.put("status","1");
                map.put("message","任务新建成功");
                return map;
            }
            else
                throw new MyException("任务号重复啦");
    }


    //返回所有任务状态的定义
    @ApiOperation(value="获取任务状态定义列表")
    @RequestMapping(value = "/statuslist", method = RequestMethod.GET)
    public List<T_status> statuslist(){
        return t_statusService.all();
    }


}
