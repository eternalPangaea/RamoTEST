package ramo.wms.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ramo.wms.test.domain.E_danwei;

import ramo.wms.test.service.E_danweiService;


import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/e")
public class E_danweiController {

    /*e_danwei的增删改查*/
    @Autowired
    private E_danweiService e_danweiService;

    @RequestMapping(value="/danwei/all")
    public List<E_danwei> all(){
        return e_danweiService.all();
    }

//    @RequestMapping(value="/danwei/id", method=RequestMethod.POST)
//    public E_danwei findByid(@RequestBody Map<String, Integer> map){
//        Integer id = map.get("danwei_id");
//        //System.out.println(logintl_id);
//        return e_danweiService.findByid(id);
//    }
//
//    @RequestMapping(value="/danwei/name", method=RequestMethod.POST)
//    public E_danwei findByname(@RequestBody Map<String, String> map){
//        String name = map.get("danwei_name");
//        //System.out.println(logintl_id);
//        return e_danweiService.findByname(name);
//   }

    @RequestMapping(value="/danwei/add", method=RequestMethod.POST)
    public String add(@RequestBody E_danwei one){
        int t = e_danweiService.add(one);
        if(t==1)
            return "success";
        else
            return "fail";
    }

    @RequestMapping(value = "/danwei/delete", method = RequestMethod.DELETE)
    public String delete(@RequestBody Map<String, String> map){
        Integer id = Integer.valueOf(map.get("danwei_id")).intValue();
        int t =  e_danweiService.delete(id);
        if(t==1)
            return "success";
        else
            return "fail";
    }


    @RequestMapping(value = "/danwei/update", method = RequestMethod.POST)
    public String update(@RequestBody E_danwei one){
        int t = e_danweiService.update(one);
        if(t==1)
            return "success";
        else
            return "fail";
    }

    /*e_dept_category*/


}
