package com.raafia.studentcrud.repository;

import com.raafia.studentcrud.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
    
}
