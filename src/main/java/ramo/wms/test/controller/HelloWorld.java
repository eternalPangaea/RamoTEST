package ramo.wms.test.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
public class HelloWorld {

    @RequestMapping("/hello")
    public @ResponseBody  String hello(){ return "Hello World"; }

    @RequestMapping("/h")
    public String hello1(){
        return "/in";
    }

    @RequestMapping("/r")
    public String hello2(){
        return "/out";
    }

    @RequestMapping("/login")
    public String login (){
        return "/login";
    }

    @RequestMapping("/broad")
    public String broad (){
        return "/broad";
    }

    @RequestMapping("/setting")
    public String setting (){
        return "/setting";
    }
}
