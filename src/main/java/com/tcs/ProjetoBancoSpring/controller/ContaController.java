package com.tcs.ProjetoBancoSpring.controller;

import com.tcs.ProjetoBancoSpring.entities.Conta;
import com.tcs.ProjetoBancoSpring.repositories.ContaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/banco")
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*" )
public class ContaController {

    @Autowired
    private ContaRepository contaRepository;

    @GetMapping("/account")
    public List<Conta> getContas(){
        return contaRepository.findAll();
    }

    @GetMapping("/account/{id}")
    public Conta getConta(@PathVariable Long id){
        Optional<Conta> optionalUser = contaRepository.findById(id);
        return optionalUser.get();
    }

    @DeleteMapping("/account/{id}")
    public boolean deleteConta(@PathVariable Long id){
        contaRepository.deleteById(id);
        return true;
    }

    @PutMapping("/account") public Conta updateConta(@RequestBody Conta user){
        return contaRepository.save(user);
    }

    @PostMapping("/account")
    public Conta createConta(@RequestBody Conta user){
        return contaRepository.save(user);
    }

    @PostMapping("/accountbalance")
    public Conta getValidation(@RequestBody Long id){
        Optional<Conta> contaRetorno = contaRepository.findAll().stream().filter(conta -> conta.getFkIdUser().getId() == id).findFirst();
        return contaRetorno.get();
    }

}
