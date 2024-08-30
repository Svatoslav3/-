package com.example.demo.Service;

import com.example.demo.Repository.Repository;
import com.example.demo.model.Models;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private Repository.UserRepository userRepository;

    public List<Models.User> getAllUsers() {
        return userRepository.findAll();
    }

    public Models.User getUserById(String userId) {
        return userRepository.findById(userId).orElse(null);
    }

    public Models.User createUser(Models.User user) {
        return userRepository.save(user);
    }

    public Models.User updateUser(String userId, Models.User userDetails) {
        Models.User user = getUserById(userId);
        if (user != null) {
            user.setPassword(userDetails.getPassword());
            user.setName(userDetails.getName());
            user.setRole(userDetails.getRole());
            return userRepository.save(user);
        }
        return null;
    }

    public void deleteUser(String userId) {
        userRepository.deleteById(userId);
    }
}

