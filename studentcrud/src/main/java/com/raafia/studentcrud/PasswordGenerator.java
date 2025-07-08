package com.raafia.studentcrud;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordGenerator {
    public static void main(String[] args) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String rawPassword = "admin123";
        String encrypted = encoder.encode(rawPassword);
        System.out.println("Encrypted password: " + encrypted);
    }
}
