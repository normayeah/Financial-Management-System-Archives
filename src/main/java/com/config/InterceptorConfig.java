package com.config; //拦截器配置

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import com.interceptor.AuthorizationInterceptor;

@Configuration //@Configuration:作为bean定义的源
public class InterceptorConfig extends WebMvcConfigurationSupport{

    @Bean //@Bean:标识产生Bean对象的方法，交给spring容器管理； Bean：类的代理
    public AuthorizationInterceptor getAuthorizationInterceptor() {
        return new AuthorizationInterceptor();
    }

    @Override //重写覆盖
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(getAuthorizationInterceptor()).addPathPatterns("/**").excludePathPatterns("/static/**");
        super.addInterceptors(registry);
    }

    /**
     * springboot 2.0配置WebMvcConfigurationSupport之后，会导致默认配置被覆盖，要访问静态资源需要重写addResourceHandlers方法
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/**") //spring boot拦截器：filepath的拦截器，使其访问到本地，addResourceLocations 的参数的这个路径上
                .addResourceLocations("classpath:/resources/")
                .addResourceLocations("classpath:/static/")
                .addResourceLocations("classpath:/admin/")
                .addResourceLocations("classpath:/front/")
                .addResourceLocations("classpath:/public/");
        super.addResourceHandlers(registry);
    }
}
