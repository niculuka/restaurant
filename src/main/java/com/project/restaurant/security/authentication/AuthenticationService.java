package com.project.restaurant.security.authentication;

import com.project.restaurant.database.model.User;
import com.project.restaurant.security.jwt.IJwtProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService implements IAuthenticationService {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    public IJwtProvider jwtProvider;

    @Override
    public User signInAndReturnJWT(User signInRequest) {
        // request
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(signInRequest.getUsername(), signInRequest.getPassword()));

        MyUserDetails myUserDetails = (MyUserDetails) authentication.getPrincipal();
        String jwt = jwtProvider.generateToken(myUserDetails);

        // response
        User signInUser = myUserDetails.getUser();
        signInUser.setToken(jwt);

        return signInUser;
    }

}
