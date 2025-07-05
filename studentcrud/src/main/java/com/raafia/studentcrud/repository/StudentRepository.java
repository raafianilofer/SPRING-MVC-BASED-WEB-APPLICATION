package com.raafia.studentcrud.repository;

import com.raafia.studentcrud.model.Student;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface StudentRepository extends JpaRepository<Student, Long> {

    @Modifying
    @Transactional
    @Query(value = "ALTER TABLE student AUTO_INCREMENT = 1", nativeQuery = true)
    void resetAutoIncrement();
}
