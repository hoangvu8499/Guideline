package com.codegym.controller_new;

import com.codegym.controller.StudentRestController;
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

@SpringBootTest
public class StudentRestController_getListStudent {

    @Autowired
    private StudentRestController studentRestController;

    @Test
    public void getListStudent_5() {

        ResponseEntity<Page<Student>> responseEntity
                = this.studentRestController.getListStudent(PageRequest.of(0, 2));

        Assertions.assertEquals(404, responseEntity.getStatusCodeValue());
    }

    @Test
    public void getListStudent_6() {

        ResponseEntity<Page<Student>> responseEntity
                = this.studentRestController.getListStudent(PageRequest.of(0, 2));

        Assertions.assertEquals(200, responseEntity.getStatusCodeValue());
        Assertions.assertEquals(3, responseEntity.getBody().getTotalPages());
        Assertions.assertEquals(5, responseEntity.getBody().getTotalElements());
        Assertions.assertEquals("Tiến",
                responseEntity.getBody().getContent().get(1).getName());
    }
}
