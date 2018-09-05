package ramo.wms.test.controller;


import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ramo.wms.test.service.E_loginService;

import java.util.HashMap;
import java.util.Map;

@RestController
@EnableTransactionManagement
public class LoginController {
    @Autowired
    private E_loginService e_loginService;

    @ApiOperation(value="登陆认证", notes="根据传入的用户名及密码，判断是否匹配，若匹配则返回跳转页面以及其用户id，用户名和昵称等信息")
    @ApiImplicitParam(name = "map",value = "用户名和密码",required = true,dataType = "Map")
    @RequestMapping(value = "/logincheck", method=RequestMethod.POST)
    public Map<String, String> login(@RequestBody Map<String ,String> map) throws MyException{
        String correct_pass = e_loginService.findpass(map.get("user_name"));
        if(correct_pass == null)
            throw new MyException("用户名不存在！");
        Map<String, String> result = new HashMap<>();
        if(correct_pass.equals(map.get("user_password"))){
            Map<String,String> map2 = e_loginService.findinfo(map.get("user_name"));
            result.put("status","1");
            result.put("message","登陆成功！");
            result.put("url","/h");
            result.put("logintl_id",String.valueOf(map2.get("logintl_id")));
            result.put("user_name",map.get("user_name"));//这里的map是前端传过来的
            result.put("nickname",map2.get("nickname"));
            result.put("image_file",map2.get("image_file"));
        }
        else{
            throw new MyException("密码错误！");
        }
        return result;
    }


    @ApiOperation(value="获取用户信息列表", notes="根据传入的用户id，返回其除了密码以外的所有信息")
    @ApiImplicitParam(name = "logintl_id",value = "用户id",required = true,dataType = "String")
    @RequestMapping(value = "/userinfo", method=RequestMethod.POST)
    public Map<String,String> userInfo(@RequestBody Map<String ,String> map) throws MyException{
        if( !map.containsKey("logintl_id") || map.get("logintl_id").equals(""))
            throw new MyException("用户名不存在！");
        Map<String, String> result = new HashMap<>();
        Map<String,String> map2 = e_loginService.findallinfo(Integer.parseInt(map.get("logintl_id")));
        result.put("user_name",map2.get("user_name"));
        result.put("login_source",map2.get("login_source"));
        result.put("ch_id",String.valueOf(map2.get("ch_id")));
        result.put("is_online",String.valueOf(map2.get("is_online")));
        result.put("image_file",map2.get("image_file"));
        result.put("nickname",map2.get("nickname"));
        result.put("phone",map2.get("phone"));
        result.put("email",map2.get("email"));
        result.put("dept_id",String.valueOf(map2.get("dept_id")));
        return result;
    }


}
