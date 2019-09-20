package com.tcs.ProjetoBancoSpring.controller;

import com.tcs.ProjetoBancoSpring.entities.Emprestimo;
import com.tcs.ProjetoBancoSpring.repositories.EmprestimoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/banco")
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*" )
public class EmprestimoController {

    @Autowired
    private EmprestimoRepository emprestimoRepository;

    @GetMapping("/loan")
    public List<Emprestimo> getEmprestimo(){
        return emprestimoRepository.findAll();
    }

    @GetMapping("/loan/{id}")
    public Emprestimo getEmprestimo(@PathVariable Long id){
        Optional<Emprestimo> optionalUser = emprestimoRepository.findById(id);
        return optionalUser.get();
    }

    @DeleteMapping("/loan/{id}")
    public boolean deleteEmprestimo(@PathVariable Long id){
        emprestimoRepository.deleteById(id);
        return true;
    }

    @PutMapping("/loan") public Emprestimo updateEmprestimo(@RequestBody Emprestimo user){
        return emprestimoRepository.save(user);
    }

    @PostMapping("/loan")
    public Emprestimo createEmprestimo(@RequestBody Emprestimo user){
        return emprestimoRepository.save(user);
    }

    @PostMapping("/loanvalidation")
    public boolean getValidation(@RequestBody Long id){
        return false;
    }

}
