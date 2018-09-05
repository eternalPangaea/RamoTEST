package ramo.wms.test.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import ramo.wms.test.dao.E_loginMapper;
import ramo.wms.test.domain.E_login;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT,timeout=36000,rollbackFor=Exception.class)
public class E_loginService {
    @Autowired(required = false)
    private E_loginMapper mapper;

    public List<E_login> all(){
        List<E_login> loginList= mapper.all();
        return loginList;
    }
    public E_login findByid(Integer logintl_id){
        E_login e_login= mapper.findByid(logintl_id);
        return e_login;
    }

    //根据用户名查找密码
    public String findpass(String user_name){
        return mapper.findPass(user_name);
    }

    //根据用户名查找logintl_id和nickname
    public Map<String, String> findinfo(String user_name){
        return mapper.findInfo(user_name);
    }

    //按照id进行搜索，返回除了密码以外的所有信息
    public Map<String, String> findallinfo(Integer logintl_id){
        return mapper.findAllInfo(logintl_id);
    }


    //根据用户id查询其权限
    public int findChid(Integer logintl_id){
        return mapper.findChid(logintl_id);
    }

    //根据用户id查询其所属部门
    public int findDeptid(Integer logintl_id){
        return mapper.findDeptid(logintl_id);
    }


    //根据部门id查旗下所有的员工
    public List<Map<String,String>> findBydept(Integer dept_id){
        List<E_login> List = mapper.findBydept(dept_id);
        List<Map<String,String>> result = new ArrayList<>();
        for (E_login i : List) {
            Map<String, String> map2 = new HashMap<>();
            map2.put("logintl_id", String.valueOf(i.getLogintl_id()));
            map2.put("user_name", i.getUser_name());
            map2.put("nickname", i.getNickname());
            result.add(map2);
        }
        return result;
    }

    public E_login findByname(String User_name){
        E_login e_login= mapper.findByname(User_name);
        return e_login;
    }

    public int add(E_login e_login){
        return mapper.add(e_login);
    }

    public int delete(Integer logintl_id){
        return mapper.delete(logintl_id);
    }

    public int update(E_login e_login){
        return mapper.update(e_login);
    }
}
