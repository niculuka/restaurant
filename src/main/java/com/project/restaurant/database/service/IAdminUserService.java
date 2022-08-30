package com.project.restaurant.database.service;

import com.project.restaurant.database.model.Role;
import com.project.restaurant.database.model.User;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public interface IAdminUserService {

    Optional<User> findByIdService(Long id);

    List<User> getAllUsers();

    @Transactional
    void changeRoleService(String username, Role role);

    @Transactional
    void changeEnabledService(Long id, Boolean enabled);

    void deleteUserService(Long id);

}
