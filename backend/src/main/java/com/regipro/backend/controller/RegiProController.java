package com.regipro.backend.controller;


import com.regipro.backend.model.RegiProModel;
import com.regipro.backend.service.RegiProService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class RegiProController {
    private final RegiProService regiProService;

    @Autowired
    public RegiProController(RegiProService regiProService) {
        this.regiProService = regiProService;
    }

    @PostMapping
    public ResponseEntity<RegiProModel> createUser(@RequestBody RegiProModel user) {
        RegiProModel createdUser = regiProService.criaUsuario(user);
        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<RegiProModel>> getAllUsers() {
        List<RegiProModel> users = regiProService.getAllUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RegiProModel> getUserById(@PathVariable Long id) {
        RegiProModel user = regiProService.getUserById(id);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateUser(@PathVariable Long id, @RequestBody RegiProModel updatedUser) {
        updatedUser.setId(id);
        regiProService.updateUser(updatedUser);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        regiProService.deleteUser(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
