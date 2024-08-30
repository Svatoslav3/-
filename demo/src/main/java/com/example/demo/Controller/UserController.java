package com.example.demo.Controller;

import com.example.demo.Service.UserService;
import com.example.demo.model.Models;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping
    public List<Models.User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{userId}")
    public Models.User getUserById(@PathVariable String userId) {
        return userService.getUserById(userId);
    }

    @PostMapping
    public Models.User createUser(@RequestBody Models.User user) {
        return userService.createUser(user);
    }

    @PutMapping("/{userId}")
    public Models.User updateUser(@PathVariable String userId, @RequestBody Models.User userDetails) {
        return userService.updateUser(userId, userDetails);
    }

    @DeleteMapping("/{userId}")
    public void deleteUser(@PathVariable String userId) {
        userService.deleteUser(userId);
    }

}