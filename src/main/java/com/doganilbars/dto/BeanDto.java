package com.doganilbars.dto;

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
}
