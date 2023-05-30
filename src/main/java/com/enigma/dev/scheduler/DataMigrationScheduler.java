package com.enigma.dev.scheduler;

import com.enigma.dev.model.Student;
import com.enigma.dev.model.StudentBackUp;
import com.enigma.dev.service.StudentBackUpService;
import com.enigma.dev.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Component
@EnableScheduling
public class DataMigrationScheduler {
    private final StudentService studentService;
    private final StudentBackUpService studentBackUpService;

    public DataMigrationScheduler(StudentService studentService, StudentBackUpService studentBackUpService) {
        this.studentService = studentService;
        this.studentBackUpService = studentBackUpService;
    }

    @Scheduled(cron = "0 */20 * * * *")
    public List<StudentBackUp> migrateDataToStudentBackUpFromStudentTable() {
        log.info("DataMigrationScheduler :: migrateDataToStudentBackUpFromStudentTable :: fixedDelay :: 20 min");
        List<Student> studentList = studentService.viewStudent();

        for (Student student : studentList) {
            studentBackUpService.saveStudentOnStudentBackupTable(student);
        }
        List<StudentBackUp> studentBackUpList = studentBackUpService.viewBackUpStudent();
        log.info("DataMigrationScheduler :: migrateDataToStudentBackUpFromStudentTable :: studentBackUpList ::", studentBackUpList);
        studentService.deleteAllStudent();
        return studentBackUpList;
    }

}
