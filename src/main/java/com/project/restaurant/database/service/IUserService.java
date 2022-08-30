package com.project.restaurant.database.service;

import com.project.restaurant.database.model.User;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public interface IUserService {

    User saveUser(User user);

    Optional<User> findByUsername(String name);

    @Transactional
    void updatePasswordService(User user);

    @Transactional
    void updateUserService(User user);

    @Transactional
    void updateEnabledService(Long id);

    void deleteUserProfileService(Long id);

}
