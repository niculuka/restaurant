package com.project.restaurant.database.controller;

import com.project.restaurant.database.model.User;
import com.project.restaurant.database.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("")
public class UserController {

    @Autowired
    private IUserService userService;



    @PutMapping("/password")
    public ResponseEntity<?> updatePasswordController(@RequestBody User user) {
        userService.updatePasswordService(user);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/profile")
    public ResponseEntity<?> updateUserController(@RequestBody User user) {
        userService.updateUserService(user);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/profile/{id}")
    public ResponseEntity<?> deleteUserProfile(@PathVariable Long id) {
        userService.deleteUserProfileService(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
