package com.galvanize.spring;

import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/math")
public class MathEndpoints {
    @GetMapping("/calculate")
    public String math(
            MathOperations mathOperations
            ) {
        return mathOperations.toString();
    }
    @PostMapping("/sum")
    public String sum(@RequestParam int[] n) {
        return MathOperations.getSumString(n);
    }

    @RequestMapping("/volume/{length}/{width}/{height}")
    public String volume(@PathVariable Map<String, String> pathVariables) {
        return MathOperations.getVolumeString(pathVariables);
    }

}
