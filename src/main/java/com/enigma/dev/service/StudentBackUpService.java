package com.enigma.dev.service;

import com.enigma.dev.model.Student;
import com.enigma.dev.model.StudentBackUp;

import java.util.List;

public interface StudentBackUpService {
    List<StudentBackUp> viewBackUpStudent();

    void saveStudentOnStudentBackupTable(Student student);
}
