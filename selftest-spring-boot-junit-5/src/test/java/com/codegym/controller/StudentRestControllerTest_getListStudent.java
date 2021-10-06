package com.codegym.controller;

import com.codegym.model.entity.Student;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.util.Assert;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
public class StudentRestControllerTest_getListStudent {

    @Autowired
    private StudentRestController studentRestController;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testGetListStudent1() throws Exception {
        mockMvc.perform(
                MockMvcRequestBuilders
                        .get("/studentRest/list")
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void testGetListStudent2() throws Exception {

        ResponseEntity<Page<Student>> responseEntity =
                this.studentRestController.getListStudent(PageRequest.of(0, 2));
        Page<Student> studentPage =
                responseEntity.getBody();
        Assertions.assertEquals(1, studentPage.getContent().get(0).getId());
        Assertions.assertEquals("Tiến", studentPage.getContent().get(0).getName());
        Assertions.assertEquals(200, responseEntity.getStatusCodeValue());
//        mockMvc.perform(
//                MockMvcRequestBuilders
//                        .get("/studentRest/list")
//                        .accept(MediaType.APPLICATION_JSON))
//                .andDo(print())
//                .andExpect(status().is2xxSuccessful())
//                .andExpect(MockMvcResultMatchers.content().json("[*].id").);
    }
}
