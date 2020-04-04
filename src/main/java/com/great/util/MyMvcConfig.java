package com.great.util;

import com.great.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MyMvcConfig implements WebMvcConfigurer {

    /*资源处理器*/
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/images/**").addResourceLocations("/WEB-INF/" + "/images/");
        registry.addResourceHandler("/back/**").addResourceLocations("/WEB-INF/" + "/back/");
        registry.addResourceHandler("/front/**").addResourceLocations("/WEB-INF/" + "/front/");
    }
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //注册TestInterceptor拦截器
        InterceptorRegistration registration = registry.addInterceptor(new LoginInterceptor());
        registration.addPathPatterns("/**");                      //所有路径都被拦截
        registration.excludePathPatterns(                         //添加不拦截路径
//                "你的登陆路径",            //登录
                "/back/js/**",            //html静态资源
                "/front/js/**",              //js静态资源
                "/images/**",             //css静态资源
                "/layui/**"
        );
    }
}

