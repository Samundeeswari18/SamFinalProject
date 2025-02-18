package com.sam.sba_html_css_javascript.authenticationProvider;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

public class AdminAuthenticationToken extends UsernamePasswordAuthenticationToken {

    public AdminAuthenticationToken(Object principal, Object credentials) {
        super(principal, credentials);
    }

    public AdminAuthenticationToken(Object principal, Object credentials, Collection<? extends GrantedAuthority> authorities) {
        super(principal, credentials, authorities);
    }
}
