package cn.edu.whu.library.common.springsecurity.config;


import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;

@Component
public class BackdoorAuthenticationProvider implements AuthenticationProvider {
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String name = authentication.getName();
        String password = authentication.getCredentials().toString();

        if ("admin".equals(name)) {
            Collection<GrantedAuthority> authorityCollection = new ArrayList<>();
            authorityCollection.add(new SimpleGrantedAuthority("ROLE_STUDENT"));
            authorityCollection.add(new SimpleGrantedAuthority("ROLE_FACULTY"));
            authorityCollection.add(new SimpleGrantedAuthority("ROLE_STAFF"));
            authorityCollection.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
            return new UsernamePasswordAuthenticationToken("Admin", password, authorityCollection);
        } else if ("ROLE_STUDENT".equals(name)) {
            Collection<GrantedAuthority> authorityCollection = new ArrayList<>();
            authorityCollection.add(new SimpleGrantedAuthority("ROLE_STUDENT"));
            return new UsernamePasswordAuthenticationToken("Student", password, authorityCollection);
        } else if ("ROLE_FACULTY".equals(name)) {
            Collection<GrantedAuthority> authorityCollection = new ArrayList<>();
            authorityCollection.add(new SimpleGrantedAuthority("ROLE_FACULTY"));
            return new UsernamePasswordAuthenticationToken("Faculty", password, authorityCollection);
        } else if ("ROLE_STAFF".equals(name)) {
            Collection<GrantedAuthority> authorityCollection = new ArrayList<>();
            authorityCollection.add(new SimpleGrantedAuthority("ROLE_STAFF"));
            return new UsernamePasswordAuthenticationToken("Staff", password, authorityCollection);
        } else {
            return null;
        }
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }

}
