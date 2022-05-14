package com.doganilbars.tutorials.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Log4j2
@Builder
public class BeanDto {
    private Long beanId;
    private String beanName;
    private String beanData;

    //başlangıç
    public void initialBean(){
        log.info("Bean başlamadan önce çalıştı");
        System.out.println("Bean başlamadan önce çalışacak method");
    }

    //bitiş
    public void destroyBean(){
        log.info("Bean bittikten sonra çalıştı");
        System.err.println("Bean bittikten sonra çalışacak method");
    }
}
