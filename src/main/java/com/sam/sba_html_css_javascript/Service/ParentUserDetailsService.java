package com.sam.sba_html_css_javascript.Service;

import com.sam.sba_html_css_javascript.Entity.Parent;
import com.sam.sba_html_css_javascript.Repository.ParentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;

@Service
public class ParentUserDetailsService implements UserDetailsService {

    @Autowired
    private ParentRepository parentRepository;

//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        Parent parent = parentRepository.findByEmail(username)
//                .orElseThrow(() -> new UsernameNotFoundException("Parent not found with email: " + username));
//        return new org.springframework.security.core.userdetails.User(parent.getParentEmail(), parent.getParentPassword(), new ArrayList<>());
//    }

//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        Parent parent = parentRepository.findByEmail(username)
//                .orElseThrow(() -> new UsernameNotFoundException("Parent not found with email: " + username));
//
//        // Assuming the method names are `getEmail` and `getPassword`
//        String email = parent.getParentEmail(); // Adjust method names if needed
//        String password = parent.getParentPassword(); // Adjust method names if needed
//
//        // For simplicity, no authorities are assigned; you can adjust this according to your needs
//        return new org.springframework.security.core.userdetails.User(email, password, Collections.emptyList());
//    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Parent parent = parentRepository.findByEmail(username)
                .orElseThrow(() -> new UsernameNotFoundException("Parent not found with email: " + username));
        return new org.springframework.security.core.userdetails.User(parent.getParentEmail(), parent.getParentPassword(), Collections.emptyList());
    }
}

