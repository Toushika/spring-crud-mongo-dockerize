package com.enigma.dev.service;

import com.enigma.dev.model.Student;

import java.util.List;

public interface StudentService {
    String addStudent(Student student);

    List<Student> viewStudent();

    String updateStudent(Student student, String id);

    String deleteStudent(String id);

    void deleteAllStudent();
}
