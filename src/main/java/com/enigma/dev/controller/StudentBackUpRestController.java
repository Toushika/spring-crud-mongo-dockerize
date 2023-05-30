package com.enigma.dev.controller;

import com.enigma.dev.model.StudentBackUp;
import com.enigma.dev.service.StudentBackUpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
public class StudentBackUpRestController {
    private final StudentBackUpService studentBackupService;

    public StudentBackUpRestController(StudentBackUpService studentBackupService) {
        this.studentBackupService = studentBackupService;
    }

    @GetMapping("/view-backup-student")
    public List<StudentBackUp> viewBackupStudent() {
        log.info("StudentBackUpRestController :: viewBackupStudent ::");
        return studentBackupService.viewBackUpStudent();
    }

}
