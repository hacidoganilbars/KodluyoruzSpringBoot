package com.doganilbars.tutorials.config;

import com.doganilbars.tutorials.dto.BeanDto;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class BeanConfig {

    @Bean(initMethod = "initialBean",destroyMethod = "destroyBean")
    @Scope("singleton") //singleton, request, session,
    public BeanDto beanDto(){
        return BeanDto.builder().beanId(0L).beanName("Bean Adi").beanData("Bean Data").build();
    }
}
