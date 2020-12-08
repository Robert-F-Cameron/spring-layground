package com.galvanize.spring;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(HelloWorld.class)

public class WebMVCTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void endPointTest() throws Exception{
        this.mvc.perform(get("/"))
                .andExpect(status().isOk());
    }
    @Test
    public void endPointMathTest() throws Exception{
        this.mvc.perform(get("/math/pi"))
                .andExpect(status().isOk());
    }
}
