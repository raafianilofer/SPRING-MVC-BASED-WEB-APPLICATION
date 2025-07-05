package com.raafia.studentcrud.controller;

import com.raafia.studentcrud.model.Student;
import com.raafia.studentcrud.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentRepository studentRepository;

    // ✅ Show all students
    @GetMapping
    public String listStudents(Model model) {
        model.addAttribute("students", studentRepository.findAll());
        return "students-list";
    }

    // ✅ Show form to add new student
    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("student", new Student());
        return "add-student";
    }

    // ✅ Save or update student
    @PostMapping("/save")
    public String saveStudent(@ModelAttribute Student student) {
        studentRepository.save(student);
        return "redirect:/students";
    }

    // ✅ Edit student by ID
    @GetMapping("/edit/{id}")
    public String editStudent(@PathVariable Long id, Model model) {
        Student student = studentRepository.findById(id).orElse(null);
        if (student != null) {
            model.addAttribute("student", student);
            return "add-student";
        } else {
            return "redirect:/students";
        }
    }

    // ✅ Delete student
    @GetMapping("/delete/{id}")
    public String deleteStudent(@PathVariable Long id) {
        studentRepository.deleteById(id);
        return "redirect:/students";
    }
}
