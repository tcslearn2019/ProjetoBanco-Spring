package com.tcs.ProjetoBancoSpring.controller;

import com.tcs.ProjetoBancoSpring.repositories.UserRepository;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.tcs.ProjetoBancoSpring.entities.User;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/banco")
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*" )
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/users")
    public List<User> getUsers(){
        return userRepository.findAll();
    }

    @GetMapping("/users/{id}")
    public User getUser(@PathVariable Long id){
        Optional<User> optionalUser = userRepository.findById(id);
        return optionalUser.get();
    }

    @DeleteMapping("/users/{id}")
    public boolean deleteUser(@PathVariable Long id){
        userRepository.deleteById(id);
        return true;
    }

    @PutMapping("/users")
    public User updateUser(@RequestBody User user){
        return userRepository.save(user);
    }

    @PostMapping("/users")
    public User createUser(@RequestBody User user){
        return userRepository.save(user);
    }



}
