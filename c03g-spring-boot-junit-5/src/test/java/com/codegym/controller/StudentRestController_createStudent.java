package com.codegym.controller;

import com.codegym.dto.StudentDto;
import com.codegym.model.entity.ClassStudent;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class StudentRestController_createStudent {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void createStudent_name_13() throws Exception {
        StudentDto studentDto = new StudentDto();
        studentDto.setName(null);
        studentDto.setDateOfBirth("2000-09-14");
        studentDto.setGrade(8.0);
        studentDto.setGender(1);

        ClassStudent classStudent = new ClassStudent();
        classStudent.setId(3);
        studentDto.setClassStudent(classStudent);

        this.mockMvc.perform(
                MockMvcRequestBuilders
                        .post("/studentRest/create")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(this.objectMapper.writeValueAsString(studentDto)))
                .andDo(print())
                .andExpect(status().is4xxClientError());

    }

    @Test
    public void createStudent_name_18() throws Exception {
        StudentDto studentDto = new StudentDto();
        studentDto.setName("Huynh");
        studentDto.setDateOfBirth("2000-09-14");
        studentDto.setGrade(8.0);
        studentDto.setGender(1);

        ClassStudent classStudent = new ClassStudent();
        classStudent.setId(3);
        studentDto.setClassStudent(classStudent);

        this.mockMvc.perform(
                MockMvcRequestBuilders
                        .post("/studentRest/create")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(this.objectMapper.writeValueAsString(studentDto)))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());

    }
}
