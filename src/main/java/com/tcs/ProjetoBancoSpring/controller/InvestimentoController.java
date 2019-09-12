package com.tcs.ProjetoBancoSpring.controller;

import com.tcs.ProjetoBancoSpring.entities.Investimento;
import com.tcs.ProjetoBancoSpring.repositories.InvestimentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/banco")
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*" )
public class InvestimentoController {
    @Autowired
    private InvestimentoRepository userRepository;

    @GetMapping("/investiment")
    public List<Investimento> getUsers(){
        return userRepository.findAll();
    }

    @GetMapping("/investiment/{id}")
    public Investimento getUser(@PathVariable Long id){
        Optional<Investimento> optionalUser = userRepository.findById(id);
        return optionalUser.get();
    }

    @DeleteMapping("/investiment/{id}")
    public boolean deleteUser(@PathVariable Long id){
        userRepository.deleteById(id);
        return true;
    }

    @PutMapping("/investiment")
    public Investimento updateUser(@RequestBody Investimento user){
        return userRepository.save(user);
    }

    @PostMapping("/investiment")
    public Investimento createUser(@RequestBody Investimento user){
        return userRepository.save(user);
    }

}
