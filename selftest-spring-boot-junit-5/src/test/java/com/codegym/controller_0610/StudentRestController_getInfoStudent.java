package com.codegym.controller_0610;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class StudentRestController_getInfoStudent {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testGetInfoStudent_1() throws Exception {

        this.mockMvc.perform(
                MockMvcRequestBuilders
                        .get("/studentRest/detail/{id}", "null"))
                .andDo(print())
                .andExpect(status().is4xxClientError());

    }

    @Test
    public void testGetInfoStudent_4() throws Exception {

        this.mockMvc.perform(
                MockMvcRequestBuilders
                        .get("/studentRest/detail/{id}", "1"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("$.name").value("Tiến"))
                .andExpect(jsonPath("$.dateOfBirth").value("2000-07-14"))
                .andExpect(jsonPath("$.classStudent.id").value("2"));
    }
}
