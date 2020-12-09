package com.galvanize.spring;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(MathEndpoints.class)
public class MathTests {
    @Autowired
    MockMvc mvc;


    @Test
    public void calculateCanAddTwoNumbers() throws Exception {
        RequestBuilder request = MockMvcRequestBuilders.get("/math/calculate?operation=add&x=4&y=6");

        this.mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string("add 4 and 6 equals 10.0"));
    }

    @Test
    public void calculateCanMultiplyTwoNumbers() throws Exception {
        RequestBuilder request = MockMvcRequestBuilders.get("/math/calculate?operation=multiply&x=4&y=6");

        this.mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string("multiply 4 and 6 equals 24.0"));
    }

    @Test
    public void calculateCanSubtractTwoNumbers() throws Exception {
        RequestBuilder request = MockMvcRequestBuilders.get("/math/calculate?operation=subtract&x=4&y=6");

        this.mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string("subtract 4 and 6 equals -2.0"));
    }

    @Test
    public void calculateCanDivideTwoNumbers() throws Exception {
        RequestBuilder request = MockMvcRequestBuilders.get("/math/calculate?operation=divide&x=30&y=5");

        this.mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string("divide 30 and 5 equals 6.0"));
    }

    @Test
    public void calculateDefaultAddTwoNumbers() throws Exception {
        RequestBuilder request = MockMvcRequestBuilders.get("/math/calculate?x=30&y=5");

        this.mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string("add 30 and 5 equals 35.0"));
    }

    @Test
    public void sumAddMultipleNumbers() throws Exception {
        RequestBuilder request = MockMvcRequestBuilders.post("/math/sum?n=4&n=5&n=6");

        this.mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string("4.0 + 5.0 + 6.0 = 15.0"));
    }

    @Test
    public void volumeOfCubeWith3ParamsPost() throws Exception {
        RequestBuilder request = MockMvcRequestBuilders.post("/math/volume/3/4/5");

        this.mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string("The volume of a 3x4x5 rectangle is 60"));
    }

    @Test
    public void volumeOfCubeWith3ParamsPatch() throws Exception {
        RequestBuilder request = MockMvcRequestBuilders.patch("/math/volume/6/7/8");

        this.mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string("The volume of a 6x7x8 rectangle is 336"));
    }
    @Test
    public void calculateCanFindAreaWidthHeight() throws Exception {
        RequestBuilder request = MockMvcRequestBuilders.get("/math/calculate?operation=area&height=4&width=4");

        this.mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string("The area of a square with a width of 4 and height of 4 equals 16.0"));
    }
    @Test
    public void calculateCanFindAreaOfCircle() throws Exception {
        RequestBuilder request = MockMvcRequestBuilders.get("/math/calculate?operation=area&radius=4");

        this.mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string("The area of a circle pi 4^2 equals 50.26548245743669"));
    }
}
