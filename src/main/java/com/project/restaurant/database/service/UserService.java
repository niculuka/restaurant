package com.project.restaurant.database.service;

import com.project.restaurant.database.model.Role;
import com.project.restaurant.database.model.User;
import com.project.restaurant.database.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class UserService implements IUserService {

    @Autowired
    private IUserRepository userRepository;

    @Autowired
    private ITokenService tokenService;

    @Autowired
    private PasswordEncoder passwordEncoder;



    @Override
    public User saveUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRole(Role.USER);
        user.setCreateTime(LocalDateTime.now());
        userRepository.save(user);

        tokenService.saveTokenService(user);

        return user;
    }

    @Override
    public Optional<User> findByUsername(String name) {
        return userRepository.findByUsername(name);
    }

    @Transactional
    @Override
    public void updatePasswordService(User user) {
        if (!passwordEncoder.matches(user.getOldPassword(), user.getPassword())
                || user.getOldPassword().equals(user.getNewPassword())
        ) {
            throw new RuntimeException("COULD NOT UPDATE PASSWORD!");
        }
        userRepository.updatePassword(user.getUsername(), passwordEncoder.encode(user.getNewPassword()));
    }

    @Transactional
    @Override
    public void updateUserService(User user) {
        userRepository.updateUser(
                user.getUsername(),
                user.getName(),
                user.getEmail(),
                user.getPhone(),
                user.getAddress()
        );
    }

    @Transactional
    @Override
    public void updateEnabledService(Long id) {
        userRepository.updateEnabled(id);
    }

    @Override
    public void deleteUserProfileService(Long id) {
        userRepository.deleteById(id);
    }

}
