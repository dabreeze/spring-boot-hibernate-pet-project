package com.foreverchild.spring_hibernate_jpa_project.dao;

import com.foreverchild.spring_hibernate_jpa_project.entity.Student;

import java.util.List;

public interface StudentDao {

    void saveStudent (Student theStudent);
    Student findById (Integer id);
    List<Student> findAll ();
    List<Student> findByLastName(String lastname);
    void update(Student student);
    void delete(Integer id);
    void deleteAll();
}
