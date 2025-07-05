package com.raafia.studentcrud.service;

import com.raafia.studentcrud.model.Student;
import com.raafia.studentcrud.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    // Get all students
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    // Save student
    public void saveStudent(Student student) {
        studentRepository.save(student);
    }

    // Get student by ID
    public Student getStudentById(Long id) {
        Optional<Student> optional = studentRepository.findById(id);
        return optional.orElse(null);
    }

    // Delete student
    public void deleteStudentById(Long id) {
        studentRepository.deleteById(id);
    }
}
