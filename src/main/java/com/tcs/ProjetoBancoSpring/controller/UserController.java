package com.tcs.ProjetoBancoSpring.controller;

import com.tcs.ProjetoBancoSpring.entities.Conta;
import com.tcs.ProjetoBancoSpring.repositories.ContaRepository;
import com.tcs.ProjetoBancoSpring.repositories.UserRepository;
import com.tcs.ProjetoBancoSpring.services.UserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.tcs.ProjetoBancoSpring.entities.User;
import com.tcs.ProjetoBancoSpring.entities.Login;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@RestController
@RequestMapping("/banco")
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*" )
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
<<<<<<< HEAD
<<<<<<< HEAD
    private UserService userService;
=======
    private ContaRepository contaRepository;
>>>>>>> origin/Guilherme
=======
    private ContaRepository contaRepository;

    @Autowired
    private UserService userService;

>>>>>>> origin/Guilherme

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
        Random rd = new Random();
        user.setAdministrador(false);
        userRepository.save(user);
        System.out.println(user);
        contaRepository.save(new Conta(user,rd.nextInt(999999),4570,0));
        return user;
    }

    @PostMapping("/validation")
    public User getValidation(@RequestBody Login login){
<<<<<<< HEAD
<<<<<<< HEAD
        return userService.login(login);
=======
        List<User> Usuarios = getUsers();
        for(User i : Usuarios){
            if(i.getCpf().equals(login.getLogin()) && i.getPwd().equals(login.getPwd())) {
                return i;
            }
        }
        Usuarios.stream().filter(line -> "one".equals(line.getFname())).forEach(System.out::println);
        return null;
>>>>>>> origin/Guilherme
=======
        return userService.login(login);
>>>>>>> origin/Guilherme
    }
}
