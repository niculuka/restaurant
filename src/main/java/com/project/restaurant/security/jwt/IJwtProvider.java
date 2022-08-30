package com.project.restaurant.security.jwt;

import com.project.restaurant.security.authentication.MyUserDetails;
import org.springframework.security.core.Authentication;

import javax.servlet.http.HttpServletRequest;

public interface IJwtProvider {

    String generateToken(MyUserDetails auth);

    Authentication getAuthentication (HttpServletRequest request);

    boolean validateToken(HttpServletRequest request);
}
