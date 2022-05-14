package com.doganilbars.tutorials.controller;

import com.doganilbars.tutorials.dto.TeacherDto;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
@Log4j2
public class FormControl {

    //http://localhost:8080/form
    //getMethod
    @GetMapping("/form")
    public String getForm(Model model){
        model.addAttribute("cv_teacher", new TeacherDto());
        return "form_post/formvalidation";
    }
    //http://localhost:8080/form
    //postMethod
    @PostMapping("/form")
    public String postForm(@Valid @ModelAttribute("cv_teacher")TeacherDto teacherDto, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            log.error("Hata var!!!");
            System.err.println("Hata var!!!");
            return "form_post/formvalidation";
        }
        log.info("Success: "+teacherDto);
        //Database kaydetme alanı veya dosyaya yazma alanı
        return "form_post/success";
    }

}
