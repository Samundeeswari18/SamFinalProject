package com.sam.sba_html_css_javascript.Service;

// src/main/java/com/example/service/AdminUserDetailsService.java

import com.sam.sba_html_css_javascript.Entity.Employee;
import com.sam.sba_html_css_javascript.Repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;

@Service
public class AdminUserDetailsService implements UserDetailsService {

    @Autowired
    private EmployeeRepository employeeRepository;

//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        Employee employee = employeeRepository.findByEmail(username)
//                .orElseThrow(() -> new UsernameNotFoundException("Employee not found with email: " + username));
//        return new org.springframework.security.core.userdetails.User(employee.getEmployeeEmail(), employee.getEmployeePassword(), new ArrayList<>());
//    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Employee employee = employeeRepository.findByEmail(username)
                .orElseThrow(() -> new UsernameNotFoundException("Employee not found with email: " + username));
        return new org.springframework.security.core.userdetails.User(employee.getEmployeeEmail(), employee.getEmployeePassword(), Collections.emptyList());
    }
}
