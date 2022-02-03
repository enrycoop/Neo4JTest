package com.example.Neo4JTest.controllers;

import com.example.Neo4JTest.models.User;
import com.example.Neo4JTest.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "/api/v1/users")
public class UserController {
    @Autowired
    private final UserService userService;

    @GetMapping
    public List<User> getUsers(){
        return userService.fetchUsers();
    }

    @GetMapping(path = "{name}")
    public User getUser(@PathVariable("name")  String name){
        return userService.fetchUser(name);
    }
}
