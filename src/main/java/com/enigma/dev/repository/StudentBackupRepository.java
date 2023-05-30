package com.enigma.dev.repository;

import com.enigma.dev.model.StudentBackUp;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface StudentBackupRepository extends MongoRepository<StudentBackUp, String> {
}
