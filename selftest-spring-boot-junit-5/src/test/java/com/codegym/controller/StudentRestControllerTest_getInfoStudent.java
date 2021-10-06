package com.codegym.controller;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
public class StudentRestControllerTest_getInfoStudent {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testGetStudent1() throws Exception {

        mockMvc.perform(
                MockMvcRequestBuilders
                        .get("/studentRest/detail/{id}", "null")
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void testGetStudent2() throws Exception {

        mockMvc.perform(
                MockMvcRequestBuilders
                        .get("/studentRest/detail/{id}", "")
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void testGetStudent3() throws Exception {

        mockMvc.perform(
                MockMvcRequestBuilders
                        .get("/studentRest/detail/{id}", "99")
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void testGetStudent4() throws Exception {

        mockMvc.perform(
                MockMvcRequestBuilders
                        .get("/studentRest/detail/{id}", "2")
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value("2"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("Nhật"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.dateOfBirth").value("2002-05-03"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.classStudent.id").value("1"));
    }
}
