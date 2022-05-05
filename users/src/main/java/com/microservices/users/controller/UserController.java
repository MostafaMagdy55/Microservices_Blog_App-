package com.microservices.users.controller;


import com.microservices.users.Wrapper.UserWithPosts;
import com.microservices.users.model.User;
import com.microservices.users.repository.UsreRepository;
import com.microservices.users.servies.UserServies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api1")
public class UserController {


    @Autowired
    UserServies userServies;

    @PostMapping("/user")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        userServies.save(user);
        return ResponseEntity.status(HttpStatus.CREATED.value()).body(user);
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<User> findUsre(@PathVariable int id) {
        User user = userServies.findById(id);
        return ResponseEntity.status(HttpStatus.FOUND.value()).body(user);
    }

    @GetMapping("/users")
    public ResponseEntity<List<User>> findAllUsre() {
        List<User> users = userServies.findAll();
        return ResponseEntity.status(HttpStatus.FOUND.value()).body(users);
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<User> delete(@PathVariable int id) {
        userServies.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @GetMapping("/user/{id}/posts")
    public ResponseEntity<UserWithPosts> userWithPosts(@PathVariable int id) {
        UserWithPosts userWithPosts = userServies.findByUserWithPosts(id);
        return new ResponseEntity<>(userWithPosts, HttpStatus.OK);
    }
}