package com.prosoft.service;

import com.prosoft.domain.UserAccess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;

@Service
public class CustomUserDetailedService implements UserDetailsService {

    private final UserAccessService userAccessService;

    @Autowired
    public CustomUserDetailedService(UserAccessService userAccessService) {
        this.userAccessService = userAccessService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserAccess userAccess = userAccessService.getUserAccess(username);
        if (userAccess == null) {
            throw new UsernameNotFoundException("User " + username + " not found!");
        }
        Collection<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority("ROLE_" + userAccess.getRole()));
        return new User(userAccess.getLogin(), userAccess.getPassword(), authorities);
    }
}
