package com.project.restaurant.database.service;

import com.project.restaurant.database.model.Token;
import com.project.restaurant.database.model.User;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public interface ITokenService {


    Token saveTokenService(User user);

    Optional<Token> getTokenService(String token);

    @Transactional
    String confirmTokenService(String token);
}
