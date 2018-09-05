//package ramo.wms.test.Config;
//
//
//import org.springframework.context.annotation.Configuration;
//import org.springframework.util.ResourceUtils;
//import org.springframework.web.servlet.config.annotation.*;
//import ramo.wms.test.Interceptor.LoginInterceptor;
//
//
//
//@Configuration
//public class WebConfig extends WebMvcConfigurationSupport {
//
//
//    @Override
//    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//        registry.addResourceHandler("/js/**").addResourceLocations(ResourceUtils.CLASSPATH_URL_PREFIX+"/js/");
//        registry.addResourceHandler("/css/**").addResourceLocations(ResourceUtils.CLASSPATH_URL_PREFIX+"/css/");
//        registry.addResourceHandler("/images/**").addResourceLocations(ResourceUtils.CLASSPATH_URL_PREFIX+"/images/");
//        registry.addResourceHandler("/static/**").addResourceLocations(ResourceUtils.CLASSPATH_URL_PREFIX+"/static/");
//        registry.addResourceHandler("/templates/**").addResourceLocations(ResourceUtils.CLASSPATH_URL_PREFIX+"/templates/");
//        super.addResourceHandlers(registry);
//    }
//
//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        //拦截规则：除了login，其他都拦截判断
//        registry.addInterceptor(new LoginInterceptor()).addPathPatterns("/sz","/kb");
//        super.addInterceptors(registry);
//    }
//}
