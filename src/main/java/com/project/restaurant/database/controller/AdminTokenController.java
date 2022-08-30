package com.project.restaurant.database.controller;

import com.project.restaurant.database.service.IAdminTokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("admin")
public class AdminTokenController {

    @Autowired
    private IAdminTokenService adminTokenService;



    @GetMapping("/tokens")
    public ResponseEntity<?> findAllTokens() {
        return new ResponseEntity<>(adminTokenService.getTokensService(), HttpStatus.OK);
    }

    @DeleteMapping("/tokens/{id}")
    public ResponseEntity<?> deleteToken(@PathVariable Long id) {
        adminTokenService.deleteTokenService(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
