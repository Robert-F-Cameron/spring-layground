package com.galvanize.spring;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/math/calculate")
public class math {
    @GetMapping
    public String getOperation(
            MathOperations mathOperations
            ) {
        return mathOperations.toString();
    }
}
