package com.doganilbars.bean;

import com.doganilbars.auidit.AuditorAwareImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;

@Configuration
public class AuditorAwareBean {

    @Bean
    public AuditorAware<String> auditorAware(){
        return  new AuditorAwareImpl();
    }
}