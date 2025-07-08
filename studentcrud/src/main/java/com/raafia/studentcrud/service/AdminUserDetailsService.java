package com.raafia.studentcrud.service;

import com.raafia.studentcrud.model.Admin;
import com.raafia.studentcrud.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.*;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AdminUserDetailsService implements UserDetailsService {

    @Autowired
    private AdminRepository adminRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("Inside loadUserByUsername");
        Admin admin = adminRepo.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
System.out.println(admin);
        return User.withUsername(admin.getUsername())
                .password(admin.getPassword())
                .roles(admin.getRole().replace("ROLE_", ""))
                .build();
    }
}
