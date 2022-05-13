package com.doganilbars.controller;

import com.doganilbars.dto.ProductDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ThymeleafController {

    @GetMapping({"/","index"})
    public String index(){
        return "index";
    }
////////////////////////////////////////////////////////////////////////////////

    //localhost:8080/thymeleaf1
    @GetMapping("/thymeleaf1")
    //@ResponseBody
    public String getThymeleaf1(){
        return "thymeleaf1";
    }
    //localhost:8080/thymeleaf2
    @GetMapping("/thymeleaf2")
    public String getThymeleaf2Model(Model model){
        model.addAttribute("key_model1","Ben Modelden geldim-1");
        model.addAttribute("key_model2","Ben Modelden geldim-2");
        return "thymeleaf1";
    }

    //localhost:8080/thymeleaf3
    @GetMapping("/thymeleaf3")
    public String getThymeleaf3Model(Model model){
        model.addAttribute("key_model1","Ben Modelden geldim-1");
        model.addAttribute("key_model2","Ben Modelden geldim-2");
        return "thymeleaf_file/thymeleaf3";
    }


    //localhost:8080/thymeleaf4
    @GetMapping("/thymeleaf4")
    public String getThymeleaf4ModelObject(Model model){
        model.addAttribute("key_model1","Ben Modelden geldim-1");
        return "thymeleaf4";
    }

    /////////////////////////////////////////////////////////////////////////////////////////////
    //Model Object Göndermek
    //localhost:8080/thymeleaf5
    @GetMapping("/thymeleaf5")
    public String getThymeleaf5ModelObject(Model model){
        model.addAttribute("key_model1","text");
        ProductDto productDto = ProductDto.builder().productId(1L).productName("Ürün Adi 1").productPrice(1500).build();
        model.addAttribute("product",productDto );
        return "thymeleaf5";
    }

    //Model Object List Göndermek
    //localhost:8080/thymeleaf6
    @GetMapping("/thymeleaf6")
    public String getThymeleaf6ModelObjectList(Model model){
        model.addAttribute("key_model1","text");
        List<ProductDto> listem = new ArrayList<>();
        listem.add(ProductDto.builder().productId(1L).productName("Ürün Adi 1").productPrice(1500).build());
        listem.add(ProductDto.builder().productId(2L).productName("Ürün Adi 2").productPrice(2500).build());
        listem.add(ProductDto.builder().productId(3L).productName("Ürün Adi 3").productPrice(3500).build());
        listem.add(ProductDto.builder().productId(4L).productName("Ürün Adi 4").productPrice(4500).build());
        listem.add(ProductDto.builder().productId(5L).productName("Ürün Adi 5").productPrice(5500).build());
        listem.add(ProductDto.builder().productId(6L).productName("Ürün Adi 6").productPrice(6500).build());
        model.addAttribute("products",listem);
        return "thymeleaf6";
    }

    //////////////////////////////////////////////////////////////////////////////////////////////////////////
    //PathVariable
    //localhost:8080/thymeleaf7/4
    @GetMapping({"/thymeleaf7","/thymeleaf7/{id}"})
    public String getThymeleaf7ModelObject(Model model, @PathVariable(name="id", required = false) Long id){
        if(id!=null){
            model.addAttribute("key_model1","id: "+id);
        }else{
            model.addAttribute("key_model1","id: Bulunamadı");
        }
        return "thymeleaf7";
    }

    //////////////////////////////////////////////////////////////////////////////////////////////////////////
    //
    //localhost:8080/thymeleaf8

}
