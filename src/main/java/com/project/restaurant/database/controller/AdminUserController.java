package com.project.restaurant.database.controller;

import com.project.restaurant.database.model.Role;
import com.project.restaurant.database.service.IAdminUserService;
import com.project.restaurant.security.authentication.IAuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("admin")
public class AdminUserController {

    @Autowired
    private IAdminUserService adminUserService;

    @Autowired
    private IAuthenticationService authenticationService;



    @GetMapping("/users")
    public ResponseEntity<?> findAllUsers() {
        return new ResponseEntity<>(adminUserService.getAllUsers(), HttpStatus.OK);
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id) {
        return new ResponseEntity<>(adminUserService.findByIdService(id), HttpStatus.OK);
    }


    @PutMapping("/change/{role}")
    public ResponseEntity<?> changeRole(@RequestBody String username, @PathVariable Role role) {
        adminUserService.changeRoleService(username, role);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/replace/{enabled}")
    public ResponseEntity<?> changeEnabled(@RequestBody Long id, @PathVariable Boolean enabled) {
        adminUserService.changeEnabledService(id, enabled);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable Long id) {
        adminUserService.deleteUserService(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
