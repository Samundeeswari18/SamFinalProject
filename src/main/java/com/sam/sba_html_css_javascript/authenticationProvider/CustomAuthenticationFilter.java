package com.sam.sba_html_css_javascript.authenticationProvider;// src/main/java/com/example/security/CustomAuthenticationFilter.java


import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class CustomAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        String email = obtainUsername(request);
        String password = obtainPassword(request);

        if (email != null && email.endsWith("@admin.com")) {
            setUsernameParameter("adminEmail");
            setPasswordParameter("adminPassword");
            return super.attemptAuthentication(request, response);
        } else {
            setUsernameParameter("parentEmail");
            setPasswordParameter("parentPassword");
            return super.attemptAuthentication(request, response);
        }
    }
}
