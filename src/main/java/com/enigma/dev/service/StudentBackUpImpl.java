package com.enigma.dev.service;

import com.enigma.dev.model.Student;
import com.enigma.dev.model.StudentBackUp;
import com.enigma.dev.repository.StudentBackupRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class StudentBackUpImpl implements StudentBackUpService {
    private final StudentBackupRepository studentBackupRepository;

    public StudentBackUpImpl(StudentBackupRepository studentBackupRepository) {
        this.studentBackupRepository = studentBackupRepository;
    }

    @Override
    public List<StudentBackUp> viewBackUpStudent() {
        log.info("StudentBackUpImpl ::  viewBackUpStudent :: studentlist :: ", studentBackupRepository.findAll());
        return studentBackupRepository.findAll();
    }

    public void saveStudentOnStudentBackupTable(Student student) {
        StudentBackUp studentBackUp = new StudentBackUp();
        studentBackUp.setId(student.getId());
        studentBackUp.setName(student.getName());
        studentBackUp.setEmail(student.getEmail());
        studentBackupRepository.save(studentBackUp);
    }
}
