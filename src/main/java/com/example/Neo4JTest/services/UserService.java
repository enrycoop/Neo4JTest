package com.example.Neo4JTest.services;

import com.example.Neo4JTest.models.User;
import com.example.Neo4JTest.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    @Autowired
    private final UserRepository userRepository;

    public List<User> fetchUsers(){
        return userRepository.findAll();
    }

    public User fetchUser(String name){
        return userRepository.getUserByName(name).get();
    }

    @Transactional
    public void updateUserName(String oldName,String newName){
        User u = userRepository.getUserByName(oldName).get();
        u.setName(newName);
        userRepository.save(u);
    }
}
