package com.tcs.ProjetoBancoSpring.controller;

import com.tcs.ProjetoBancoSpring.entities.Conta;
import com.tcs.ProjetoBancoSpring.repositories.ContaRepository;
import com.tcs.ProjetoBancoSpring.services.ContaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/banco")
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*" )
public class ContaController {

    @Autowired
    private ContaService service;

    @GetMapping("/account")
    public List<Conta> getContas(){
        return service.findAll();
    }

    @GetMapping("/account/{id}")
    public Conta getConta(@PathVariable Long id){
        return service.findById(id);
    }

    @DeleteMapping("/account/{id}")
    public boolean deleteConta(@PathVariable Long id){
        return service.deleteById(id);
    }

    @PutMapping("/account")
    public Conta updateConta(@RequestBody Conta conta){
        return service.updateConta(conta);
    }

    @PostMapping("/account")
    public Conta createConta(@RequestBody Conta conta){
        return service.createAccount(conta);
    }

    @PostMapping("/accountbalance")
    public Conta getValidation(@RequestBody Long id){
        return service.findByUserId(id);
    }

}
