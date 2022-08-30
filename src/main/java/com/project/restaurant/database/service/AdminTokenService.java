package com.project.restaurant.database.service;

import com.project.restaurant.database.model.Token;
import com.project.restaurant.database.repository.IAdminTokenRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class AdminTokenService implements IAdminTokenService{

    private final IAdminTokenRepository adminTokenRepository;



    @Override
    public List<Token> getTokensService() {
        return  adminTokenRepository.findAll();
    }

    @Override
    public void deleteTokenService(Long id) {
        adminTokenRepository.deleteById(id);
    }

}
