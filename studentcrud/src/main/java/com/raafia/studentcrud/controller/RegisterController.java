package com.raafia.studentcrud.controller;

import com.raafia.studentcrud.model.User;
import com.raafia.studentcrud.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class RegisterController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("/register")
    public String showRegisterForm(User user) {
        return "register";
    }

    @PostMapping("/register")
public String processRegister(User user) {
System.out.println("Registering user: " + user.getUsername());
user.setPassword(passwordEncoder.encode(user.getPassword()));
userRepository.save(user);
return "redirect:/login";
}
}
