package com.project.restaurant.database.service;

import com.project.restaurant.database.model.Token;

import java.util.List;

public interface IAdminTokenService {

    List<Token> getTokensService();

    void deleteTokenService(Long id);

}
