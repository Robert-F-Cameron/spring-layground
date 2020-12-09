package com.galvanize.spring;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class FormDataEndpoints {
    @PostMapping("/endpoint")
    public String showFormData (@RequestParam Map<String, String> body){
        return body.toString();
    }
}
