package com.harshit.CoadingQuiz.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class webConfig implements WebMvcConfigurer {


    public void addCorsMapping(CorsRegistry registry)
    {
        registry.addMapping("/api/**")//Allow all end points
                .allowedOrigins("http://127.0.0.1:3000/") //Allows your frontend origin
                .allowedMethods("GET","POST","PUT","DELETE","OPTIONS")
                .allowedHeaders("*")
                .allowCredentials(true);

    }
}
