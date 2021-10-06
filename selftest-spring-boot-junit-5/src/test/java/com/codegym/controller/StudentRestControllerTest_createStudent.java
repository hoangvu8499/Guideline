package com.codegym.controller;

import com.codegym.dto.StudentDto;
import com.codegym.model.entity.ClassStudent;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
public class StudentRestControllerTest_createStudent {
//
//    @Autowired
//    private MockMvc mockMvc;
//
//    @Autowired
//    private ObjectMapper objectMapper;
//
//    @Test
//    public void testCreateStudent14() throws Exception {
//
//        StudentDto studentDto = new StudentDto();
//        studentDto.setName("");
//        studentDto.setDateOfBirth("");
//        studentDto.setGender(1);
//        studentDto.setGrade(5.0);
//        ClassStudent classStudent = new ClassStudent();
//        classStudent.setId(3);
//        studentDto.setClassStudent(classStudent);
//
//        mockMvc.perform(
//                MockMvcRequestBuilders
//                        .post("/studentRest/create")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content(objectMapper.writeValueAsString(studentDto)))
//                .andDo(MockMvcResultHandlers.print())
//                .andExpect(status().is4xxClientError());
//    }
//
//    @Test
//    public void testCreateStudent18() throws Exception {
//
//        StudentDto studentDto = new StudentDto();
//        studentDto.setName("Nguyễn Văn A");
//        studentDto.setDateOfBirth("2021-09-11");
//        studentDto.setGender(1);
//        studentDto.setGrade(5.0);
//        ClassStudent classStudent = new ClassStudent();
//        classStudent.setId(3);
//        studentDto.setClassStudent(classStudent);
//
//        mockMvc.perform(
//                MockMvcRequestBuilders
//                        .post("/studentRest/create")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content(objectMapper.writeValueAsString(studentDto)))
//                .andDo(MockMvcResultHandlers.print())
//                .andExpect(status().is2xxSuccessful());
//    }

}
