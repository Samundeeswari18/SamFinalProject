package com.sam.sba_html_css_javascript.authenticationProvider;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

public class ParentAuthenticationToken extends UsernamePasswordAuthenticationToken {

    public ParentAuthenticationToken(Object principal, Object credentials) {
        super(principal, credentials);
    }

    public ParentAuthenticationToken(Object principal, Object credentials, Collection<? extends GrantedAuthority> authorities) {
        super(principal, credentials, authorities);
    }
}
