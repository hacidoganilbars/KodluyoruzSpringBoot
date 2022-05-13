package com.doganilbars.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ThymeleafController {

    //localhost:8080/thymeleaf1
    @GetMapping("/thymeleaf1")
    //@ResponseBody
    public String getThymeleaf1(){
        return "thymeleaf1";
    }
    //localhost:8080/thymeleaf2
    @GetMapping("thymeleaf2")
    public String getThymeleaf2Model(Model model){
        model.addAttribute("key_model1","Ben Modelden geldim-1");
        model.addAttribute("key_model2","Ben Modelden geldim-2");
        return "thymeleaf1";
    }

    //localhost:8080/thymeleaf3
    @GetMapping("thymeleaf3")
    public String getThymeleaf3Model(Model model){
        model.addAttribute("key_model1","Ben Modelden geldim-1");
        model.addAttribute("key_model2","Ben Modelden geldim-2");
        return "thymeleaf_file/thymeleaf3";
    }
}
