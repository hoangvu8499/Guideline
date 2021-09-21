package com.codegym.model.service;

import com.codegym.model.entity.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IStudentService {
    void save(Student student);
    List<Student> findAll();
    Page<Student> findAll(Pageable pageable);
    Page<Student> findAllSearchName(Pageable pageable, String keyword);
    Student findById(Integer id);
}
