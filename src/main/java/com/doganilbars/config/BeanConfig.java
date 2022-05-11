package com.doganilbars.config;

import com.doganilbars.dto.BeanDto;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {

    @Bean
    public BeanDto beanDto(){
        return BeanDto.builder().beanId(0L).beanName("Bean Adi").beanData("Bean Data").build();
    }
}
