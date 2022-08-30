package com.project.restaurant.security.authentication;

import com.project.restaurant.database.model.User;

public interface IAuthenticationService {

    User signInAndReturnJWT(User signInRequest);

}
