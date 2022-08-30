package com.project.restaurant.database.service;

import com.project.restaurant.database.model.Role;
import com.project.restaurant.database.model.User;
import com.project.restaurant.database.repository.IAdminUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class AdminUserService implements IAdminUserService{

    @Autowired
    private IAdminUserRepository adminUserRepository;



    @Override
    public Optional<User> findByIdService(Long id) {
        return adminUserRepository.findById(id);
    }

    @Override
    public List<User> getAllUsers() {
        return adminUserRepository.findAll();
    }

    @Transactional
    @Override
    public void changeRoleService(String username, Role role) {
        adminUserRepository.updateUserRole(username, role);
    }

    @Transactional
    @Override
    public void changeEnabledService(Long id, Boolean enabled) {
        adminUserRepository.updateEnabled(id, enabled);
    }

    @Override
    public void deleteUserService(Long id) {
        adminUserRepository.deleteById(id);
    }

}
