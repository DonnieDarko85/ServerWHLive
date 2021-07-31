package com.example.accessingdatamysql;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class MainController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping(path="/soci")
    public ResponseEntity<List<User>> getAllUsers() {
        return userRepository.findAll();
    }

    @GetMapping(path="/soci/{id}")
    public @ResponseBody Iterable<User> getUserById() {
        return userRepository.findAll();
    }
}