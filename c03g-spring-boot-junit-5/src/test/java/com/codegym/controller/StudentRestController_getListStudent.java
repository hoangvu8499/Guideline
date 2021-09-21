package com.codegym.controller;

import com.codegym.model.entity.Student;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class StudentRestController_getListStudent {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private StudentRestController studentRestController;

    @Test
    public void getListStudent_5() throws Exception {

        this.mockMvc.perform(
                MockMvcRequestBuilders.get("/studentRest/list"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void getListStudent_6() {
        ResponseEntity<Page<Student>> pageResponseEntity
                = this.studentRestController.getListStudent(
                        PageRequest.of(0, 2));
        Page<Student> studentPage = pageResponseEntity.getBody();
        int statusCode = pageResponseEntity.getStatusCodeValue();

        Assertions.assertEquals(200, statusCode);
        Assertions.assertEquals(5, studentPage.getTotalElements());
        Assertions.assertEquals(3, studentPage.getTotalPages());
        Assertions.assertEquals(1, studentPage.getContent().get(0).getId());
        Assertions.assertEquals("Tiến", studentPage.getContent().get(0).getName());
        //...
    }
}
