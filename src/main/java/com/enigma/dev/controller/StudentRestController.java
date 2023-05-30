package com.enigma.dev.controller;

import com.enigma.dev.model.Student;
import com.enigma.dev.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
public class StudentRestController {
    private final StudentService studentService;

    public StudentRestController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("/add-student")
    public String addStudent(@RequestBody Student student) {
        log.info("StudentRestController :: addStudent :: student :: {}", student);
        return studentService.addStudent(student);
    }

    @GetMapping("/view-student")
    public List<Student> viewStudent() {
        log.info("StudentRestController :: viewStudent ::");
        return studentService.viewStudent();
    }

    @PutMapping("/update-student/{id}")
    public String updateStudent(@RequestBody Student student, @PathVariable String id) {
        log.info("StudentRestController :: updateStudent :: student :: {} :: id :: {}", student, id);
        return studentService.updateStudent(student, id);
    }

    @DeleteMapping("/delete-student/{id}")
    public String deleteStudent(@PathVariable String id) {
        log.info("StudentRestController :: deleteStudent :: id :: {}", id);
        return studentService.deleteStudent(id);
    }
}
