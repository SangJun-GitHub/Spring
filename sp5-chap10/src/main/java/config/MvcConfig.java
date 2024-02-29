package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.HttpRequestHandler;
import org.springframework.web.servlet.HandlerAdapter;
import org.springframework.web.servlet.HandlerMapping;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.handler.SimpleUrlHandlerMapping;
import org.springframework.web.servlet.mvc.HttpRequestHandlerAdapter;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;
import org.springframework.web.servlet.resource.DefaultServletHttpRequestHandler;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Sang Jun Park on 03/01/2024.
 * GitHub : http://github.com/SangJun-GitHub
 */

@Configuration
public class MvcConfig{

    @Bean
    public HandlerMapping handlerMapping(){
        RequestMappingHandlerMapping hm = new RequestMappingHandlerMapping();
        hm.setOrder(0);
        return hm;
    }

    @Bean
    public HandlerAdapter handlerAdapter(){
        return new RequestMappingHandlerAdapter();
    }

    @Bean
    public HandlerMapping simpleHandlerMapping(){
        SimpleUrlHandlerMapping hm = new SimpleUrlHandlerMapping();
        Map<String, Object> pathMap = new HashMap<>();
        pathMap.put("/**", defaultServletHandler());
        hm.setUrlMap(pathMap);
        return hm;
    }

    @Bean
    public HttpRequestHandler defaultServletHandler(){
        return  new DefaultServletHttpRequestHandler();
    }

    @Bean
    public HandlerAdapter requestHandlerAdapter(){
        return new HttpRequestHandlerAdapter();
    }

    @Bean
    public ViewResolver viewResolver(){
        InternalResourceViewResolver vr = new InternalResourceViewResolver();
        vr.setPrefix("/WEB-INF/view/");
        vr.setSuffix(".jsp");
        return vr;
    }
}
