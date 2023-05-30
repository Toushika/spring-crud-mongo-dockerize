package com.enigma.dev.service;

import com.enigma.dev.model.Student;
import com.enigma.dev.repository.StudentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public String addStudent(Student student) {
        log.info("StudentServiceImpl :: addStudent :: student :: {}", student);
        Student studentInfo = studentRepository.save(student);
        return "Student Info saved successfully - " + studentInfo.getName();
    }

    @Override
    public List<Student> viewStudent() {
        List<Student> studentList = studentRepository.findAll();
        log.info("StudentServiceImpl :: viewStudent :: studentList :: {}", studentList);
        return studentList;
    }

    @Override
    public String updateStudent(Student student, String id) {
        log.info("StudentServiceImpl :: updateStudent :: student :: {} :: id :: {}", student, id);
        student.setId(id);
        studentRepository.save(student);
        return "Student - " + student.getName() + " has been updated successfully";
    }

    @Override
    public String deleteStudent(String id) {
        studentRepository.deleteById(id);
        return "Student - " + id + "has been deleted successfully.";
    }
}
