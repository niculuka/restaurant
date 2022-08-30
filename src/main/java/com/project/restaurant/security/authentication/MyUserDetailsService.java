package com.project.restaurant.security.authentication;

import com.project.restaurant.database.model.User;
import com.project.restaurant.database.service.IUserService;
import com.project.restaurant.utils.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private IUserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = userService.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("NOT FOUND USERNAME: " + username));

        if (!user.getUsername().equals(username)) {
            throw new UsernameNotFoundException("NOT MATCHED USERNAME");
        }

        Set<GrantedAuthority> authorities = Set.of(SecurityUtils.convertToAuthority(user.getRole().name()));

        return MyUserDetails.builder()
                .user(user)
                .id(user.getUserId())
                .username(username)
                .password(user.getPassword())
                .enabled(user.getEnabled())
                .authorities(authorities)
                .build();
    }
}
