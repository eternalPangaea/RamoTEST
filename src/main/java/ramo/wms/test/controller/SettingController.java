package ramo.wms.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ramo.wms.test.domain.*;
import ramo.wms.test.service.*;



import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static ramo.wms.test.domain.AesEncryptUtils.decrypt;
import static ramo.wms.test.domain.AesEncryptUtils.encrypt;

@RestController
@EnableTransactionManagement
@RequestMapping("/setting")
public class SettingController {
    //加密值见application.properties
    @Value("${aes.KEY}")
    private String KEY;

    @Autowired
    private E_danweiService e_danweiService;
    @Autowired
    private E_authority_typeService e_authority_typeService;
    @Autowired
    private E_loginService e_loginService;
    @Autowired
    private E_dept_categoryService e_dept_categoryService;
    @Autowired
    private E_ch_authorityService e_ch_authorityService;
    @Autowired
    private T_typeService t_typeService;
    @Autowired
    private E_matl_structure1Service e_matl_structure1Service;
    @Autowired
    private E_matl_defService e_matl_defService;

    //新增一个单位定义，只需要传入单位名称即可
    @RequestMapping(value="/adddanwei",method = RequestMethod.POST)
    public Map<String, String> addDanwei(@RequestBody E_danwei e_danwei) throws MyException{
        Map<String,String> result = new HashMap<>();
        int t = e_danweiService.add(e_danwei);
        if(t == 1){
            result.put("status","1");
            result.put("message","添加成功");
            return result;
        }
        else
            throw new MyException("添加失败");
    }

    //查看所有的单位定义
    @RequestMapping(value = "/alldanwei", method = RequestMethod.GET)
    public List<E_danwei> allDanwei() throws Exception {
        String content = "派大星";
        System.out.println("加密前：" + KEY);

        String encrypt = encrypt(content, KEY);
        System.out.println("加密后：" + encrypt);

        String decrypt = decrypt(encrypt, KEY);
        System.out.println("解密后：" + decrypt);
        return e_danweiService.all(); }

    //删除一个单位定义
    @RequestMapping(value="/deletedanwei", method = RequestMethod.DELETE)
    public Map<String, String> deleteDanwei(@RequestBody Map<String,String> param) throws MyException{
        Map<String,String> result = new HashMap<>();
        String danwei_id = param.get("danwei_id");
        int t = e_danweiService.delete(Integer.parseInt(danwei_id));
        if(t==1){
            result.put("status","1");
            result.put("message","删除成功");
            return result;
        }
        else
            throw new MyException("删除失败");
    }

    //改一个单位定义
    @RequestMapping(value = "/updatedanwei",method = RequestMethod.POST)
    public Map<String,String> updateDanwei(@RequestBody E_danwei e_danwei) throws MyException{
        Map<String,String> result = new HashMap<>();
        int t = e_danweiService.update(e_danwei);
        if(t == 1){
            result.put("status","1");
            result.put("message","修改成功");
            return result;
        }
        else
            throw new MyException("修改失败");
    }

//-----------------------------------------------------------------------------------------------------------------
//新增一个权限定义，只需要传入权限名称即可
    @RequestMapping(value="/addauthority",method = RequestMethod.POST)
    public Map<String, String> addAuthority(@RequestBody E_authority_type e_authority_type) throws MyException{
    Map<String,String> result = new HashMap<>();
    int t = e_authority_typeService.add(e_authority_type);
    if(t==1){
        result.put("status","1");
        result.put("message","添加成功");
        return result;
    }
    else
        throw new MyException("添加失败");
}

    //查看所有的权限定义
    @RequestMapping(value = "/allauthority", method = RequestMethod.GET)
    public List<E_authority_type> allAuthority(){ return e_authority_typeService.all(); }

    //删除一个权限定义
    @RequestMapping(value="/deleteauthority", method = RequestMethod.DELETE)
    public Map<String, String> deleteAuthority(@RequestBody Map<String,String> param) throws MyException{
        Map<String,String> result = new HashMap<>();
        String authority_id = param.get("authority_id");
        int t = e_authority_typeService.delete(Integer.parseInt(authority_id));
        if(t==1){
            result.put("status","1");
            result.put("message","删除成功");
            return result;
        }
        else
            throw new MyException("删除失败");
    }

    //改一个权限定义
    @RequestMapping(value = "/updateauthority",method = RequestMethod.POST)
    public Map<String,String> updateAuthority(@RequestBody E_authority_type e_authority_type) throws MyException{
        Map<String,String> result = new HashMap<>();
        int t = e_authority_typeService.update(e_authority_type);
        if(t==1){
            result.put("status","1");
            result.put("message","修改成功");
            return result;
        }
        else
            throw new MyException("修改失败");
    }

    //---------------------------------------------------------------------------------------------------------------

    //添加一个员工账号
    @RequestMapping(value="/adduser", method = RequestMethod.POST)
    public Map<String, String> addUser(@RequestBody E_login e_login) throws MyException{
        Map<String,String> result = new HashMap<>();
        int t =e_loginService.add(e_login);
        if(t == 1){
            result.put("status", "1");
            result.put("message", "添加成功");
            return result;
        }
        else
            throw new MyException("添加失败");
    }

    //查看所有的员工账号
    @RequestMapping(value = "/alluser", method = RequestMethod.GET)
    public List<E_login> allUser(){ return e_loginService.all(); }

    //删除一个员工账号
    @RequestMapping(value="/deleteuser", method = RequestMethod.DELETE)
    public Map<String, String> deleteUser(@RequestBody Map<String,String> param) throws MyException{
        Map<String,String> result = new HashMap<>();
        String logintl_id = param.get("logintl_id");
        int t = e_loginService.delete(Integer.parseInt(logintl_id));
        if(t==1){
            result.put("status","1");
            result.put("message","删除成功");
            return result;
        }
        else
            throw new MyException("删除失败");
    }

    //改一个用户账号
    @RequestMapping(value = "/updateuser",method = RequestMethod.POST)
    public Map<String,String> updateUser(@RequestBody E_login e_login) throws MyException{
        Map<String,String> result = new HashMap<>();
        int t = e_loginService.update(e_login);
        if(t == 1){
            result.put("status","1");
            result.put("message","修改成功");
            return result;
        }
        else
            throw new MyException("修改失败");
    }

    //---------------------------------------------------------------------------------------------------------------
    //新建一个部门定义（传入一个新部门，其中subdept_ids要加英文逗号隔开）
    @RequestMapping(value = "/adddept", method = RequestMethod.POST)
    public Map<String, String> addDept(@RequestBody E_dept_category e_dept_category) throws MyException{
        Map<String, String> result = new HashMap<>();
        int t = e_dept_categoryService.add(e_dept_category);
        if(t == 1){
            result.put("status","1");
            result.put("message","添加成功");
            return result;
        }
        else
            throw new MyException("添加失败");
    }

    //获取所有部门
    @RequestMapping(value = "/alldept", method = RequestMethod.GET)
    public List<E_dept_category> allDept(){

        return e_dept_categoryService.all();
    }

    //删除一个部门
    @RequestMapping(value = "/deletedept", method = RequestMethod.DELETE)
    public Map<String, String> deleteDept(@RequestBody Map<String, String> param) throws MyException{
        Map<String, String> result = new HashMap<>();
        int t = e_dept_categoryService.delete(Integer.parseInt(param.get("dept_id")));
        if(t == 1){
            result.put("status","1");
            result.put("message","删除成功");
            return result;
        }
        else
            throw new MyException("删除失败");
    }

    //改一个部门
    @RequestMapping(value = "/updatedept", method = RequestMethod.POST)
    public Map<String, String> updateDept(@RequestBody E_dept_category e_dept_category) throws MyException{
        Map<String, String> result = new HashMap<>();
        int t = e_dept_categoryService.update(e_dept_category);
        if(t == 1){
            result.put("status","1");
            result.put("message","修改成功");
            return result;
        }
        else
            throw new MyException("修改失败");
    }

    //-------------------------------------------------------------------------------------------------------------
    //新建一个角色权限
    @RequestMapping(value = "/addch", method = RequestMethod.POST)
    public Map<String, String> addCh(@RequestBody E_ch_authority e_ch_authority) throws MyException{
        Map<String,String> result = new HashMap<>();
        int t = e_ch_authorityService.add(e_ch_authority);
        if(t == 1){
            result.put("status","1");
            result.put("message","添加成功");
            return result;
        }
        else
            throw new MyException("添加失败");
    }

    //获取全部角色权限
    @RequestMapping(value = "/allch", method = RequestMethod.GET)
    public List<E_ch_authority> allCh(){
        return e_ch_authorityService.all();
    }

    //删除一个角色权限
    @RequestMapping(value = "/deletech", method = RequestMethod.DELETE)
    public Map<String, String> deleteCh(@RequestBody Map<String, String> param) throws MyException{
        Map<String, String> result = new HashMap<>();
        int t = e_ch_authorityService.delete(Integer.parseInt(param.get("ch_id")));
        if(t == 1){
            result.put("status","1");
            result.put("message","删除成功");
            return result;
        }
        else
            throw new MyException("删除失败");
    }

    //修改一个角色权限
    @RequestMapping(value = "/updatech", method = RequestMethod.POST)
    public Map<String, String> updateCh(@RequestBody E_ch_authority e_ch_authority) throws MyException{
        Map<String, String> result = new HashMap<>();
        int t = e_ch_authorityService.update(e_ch_authority );
        if(t == 1){
            result.put("status","1");
            result.put("message","修改成功");
            return result;
        }
        else
            throw new MyException("修改失败");
    }

    //-------------------------------------------------------------------------------------------------------------
    //新建一个任务类型
    @RequestMapping(value = "/addtasktype", method=RequestMethod.POST)
    public Map<String, String> addTasktype(@RequestBody T_type t_type) throws MyException{
        Map<String, String> result = new HashMap<>();
        int t = t_typeService.update(t_type);
        if(t == 1){
            result.put("status","1");
            result.put("message","添加成功");
            return result;
        }
        else
            throw new MyException("添加失败");
    }

    //删除一个任务类型
    @RequestMapping(value = "/deletetasktype", method = RequestMethod.DELETE)
    public Map<String, String> deleteTasktype(@RequestBody Map<String, String> param) throws MyException{
        Map<String, String> result = new HashMap<>();
        int t = t_typeService.delete(Integer.parseInt(param.get("t_typeid")));
        if(t == 1){
            result.put("status","1");
            result.put("message","删除成功");
            return result;
        }
        else
            throw new MyException("删除失败");
    }

    //修改一个任务类型
    @RequestMapping(value = "updatetasktype", method = RequestMethod.POST)
    public Map<String, String> updateTasktype(@RequestBody T_type t_type) throws MyException{
        Map<String, String> result = new HashMap<>();
        int t = t_typeService.update(t_type);
        if(t == 1){
            result.put("status","1");
            result.put("message","修改成功");
            return result;
        }
        else
            throw new MyException("修改失败");
    }

    //-------------------------------------------------------------------------------------------------------------
    //！！！！！！批量增加
    @RequestMapping(value = "/addmatlstructs",method = RequestMethod.POST)
    public Map<String, String> addMatl(@RequestBody List<E_matl_structure1> e_matl_structure1s) throws MyException{
        Map<String, String> result = new HashMap<>();
        int t = e_matl_structure1Service.addlot(e_matl_structure1s);
        if(t != 0){
            result.put("status","1");
            result.put("message","添加成功");
            return result;
        }
        else
            throw new MyException("添加失败");
    }

    @RequestMapping( value = "/allmatlstruct", method = RequestMethod.GET)
    public List<E_matl_structure1> allMatlStruct(){
        return e_matl_structure1Service.all();
    }

    @RequestMapping(value = "/deletematlstruct", method = RequestMethod.DELETE)
    public Map<String,String> deleteMatlstruct(@RequestBody Map<String, String> param) throws MyException{
        Map<String, String> result = new HashMap<>();
        int t = e_matl_structure1Service.delete(param.get("matl_structid"));
        if(t == 1){
            result.put("status","1");
            result.put("message","删除成功");
            return result;
        }
        else
            throw new MyException("删除失败");
    }

    @RequestMapping(value = "/updatematlstruct", method = RequestMethod.POST)
    public Map<String, String> updateMatlstruct(@RequestBody E_matl_structure1 e_matl_structure1) throws MyException{
        Map<String, String> result = new HashMap<>();
        int t = e_matl_structure1Service.update(e_matl_structure1);
        if(t == 1){
            result.put("status","1");
            result.put("message","修改成功");
            return result;
        }
        else
            throw new MyException("修改失败");
    }

    //----------------------------------------------------------------------------------------------------------------
    @RequestMapping(value = "/addmatl", method = RequestMethod.POST)
    public Map<String, String> addMatl(@RequestBody E_matl_def e_matl_def) throws MyException{
            Map<String, String> result = new HashMap<>();
            int t = e_matl_defService.add(e_matl_def);
            if(t == 1){
                result.put("status","1");
                result.put("message","添加成功");
                return result;
            }
            else
                throw new MyException("添加失败");
        }

    @RequestMapping( value = "/allmatl", method = RequestMethod.GET)
    public List<E_matl_def> allMatl(){
        return e_matl_defService.all();
    }

    @RequestMapping(value = "/deletematl", method = RequestMethod.DELETE)
    public Map<String,String> deleteMatl(@RequestBody Map<String, String> param) throws MyException{
        Map<String, String> result = new HashMap<>();
        int t = e_matl_defService.delete(param.get("matl_id"));
        if(t == 1){
            result.put("status","1");
            result.put("message","删除成功");
            return result;
        }
        else
            throw new MyException("删除失败");
    }

    @RequestMapping(value = "/updatematl", method = RequestMethod.POST)
    public Map<String, String> updateMatl(@RequestBody E_matl_def e_matl_def) throws MyException{
        Map<String, String> result = new HashMap<>();
        int t = e_matl_defService.update(e_matl_def);
        if(t == 1){
            result.put("status","1");
            result.put("message","修改成功");
            return result;
        }
        else
            throw new MyException("修改失败");
    }

    @RequestMapping(value = "/piliang",method = RequestMethod.POST)
    public Map<String, String> addlots(@RequestBody List<E_danwei> ones) throws MyException{
        Map<String, String> result = new HashMap<>();
        int t = e_danweiService.addlots(ones);
        if(t != 0){
            result.put("status","1");
            result.put("message","添加成功");
            return result;
        }
        else
            throw new MyException("添加失败");
    }
}
