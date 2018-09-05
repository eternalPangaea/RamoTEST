package ramo.wms.test;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestMapping;
import ramo.wms.test.domain.AesEncryptUtils;

@SpringBootApplication
//@ComponentScan(basePackages = {"ramo.wms.test.controller","ramo.wms.test.domain","ramo.wms.test.dao","ramo.wms.test.service"})
//@MapperScan(basePackages = {"ramo.wms.test.dao"})
public class TestApplication {


    public static void main(String[] args) {

        SpringApplication.run(TestApplication.class, args);

    }
}


//public class TestApplication extends SpringBootServletInitializer {
//    @Override
//    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
//
//        return builder.sources(TestApplication.class);
//    }
//
//
//    public static void main(String[] args) {
//        SpringApplication.run(TestApplication.class, args);
//    }
//}
