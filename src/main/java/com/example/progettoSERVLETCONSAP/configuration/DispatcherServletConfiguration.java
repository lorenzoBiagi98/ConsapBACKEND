package com.example.progettoSERVLETCONSAP.configuration;


//import com.example.progettoSERVLETCONSAP.Servlet.CustomDispatcherServlet;
import org.springframework.boot.autoconfigure.web.servlet.DispatcherServletPath;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.handler.HandlerMappingIntrospector;
/*
@Configuration
public class DispatcherServletConfiguration{

    @Bean
    public DispatcherServletPath dispatcherServletPath() {
        return () -> "/";
    }

    @Bean
    public HandlerMappingIntrospector handlerMappingIntrospector() {
        return new HandlerMappingIntrospector();
    }

    @Bean
    public ServletRegistrationBean<CustomDispatcherServlet> customDispatcherServletRegistration() {
        ServletRegistrationBean<CustomDispatcherServlet> registrationBean = new ServletRegistrationBean<>(new CustomDispatcherServlet(), "/api/login");
        registrationBean.setLoadOnStartup(1);
        return registrationBean;
    }

    @Bean
    public ServletRegistrationBean<DispatcherServlet> dispatcherServletRegistration(DispatcherServlet dispatcherServlet) {
        ServletRegistrationBean<DispatcherServlet> registrationBean = new ServletRegistrationBean<>(dispatcherServlet, "/");
        registrationBean.setLoadOnStartup(1);
        registrationBean.setOrder(Ordered.LOWEST_PRECEDENCE);
        return registrationBean;
    }
}

*/
