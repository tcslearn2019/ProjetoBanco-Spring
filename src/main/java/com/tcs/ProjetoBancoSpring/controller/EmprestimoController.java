package com.tcs.ProjetoBancoSpring.controller;

import com.tcs.ProjetoBancoSpring.entities.Conta;
import com.tcs.ProjetoBancoSpring.entities.Emprestimo;
import com.tcs.ProjetoBancoSpring.entities.ParamEmprestimo;
import com.tcs.ProjetoBancoSpring.entities.User;
import com.tcs.ProjetoBancoSpring.repositories.ContaRepository;
import com.tcs.ProjetoBancoSpring.repositories.EmprestimoRepository;
import com.tcs.ProjetoBancoSpring.repositories.UserRepository;
import com.tcs.ProjetoBancoSpring.services.EmprestimoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/banco")
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
public class EmprestimoController {

    @Autowired
    private EmprestimoService service;

    @GetMapping("/loan")
    public List<Emprestimo> getEmprestimo() {
        return service.findAll();
    }

    @GetMapping("/loan/{id}")
    public Emprestimo getEmprestimo(@PathVariable Long id) {
        return service.findById(id);
    }

    @DeleteMapping("/loan/{id}")
    public boolean deleteEmprestimo(@PathVariable Long id) {
        return service.deleteById(id);
    }

    @PutMapping("/loan")
    public Emprestimo updateEmprestimo(@RequestBody Emprestimo paramEmprestimo) {
        return service.update(paramEmprestimo);
    }

    @PostMapping("/loan")
    public Emprestimo createEmprestimo(@RequestBody ParamEmprestimo paramEmprestimo) {
        return service.createEmprestimo(paramEmprestimo);

    }

    @PostMapping("/loanpersonal")
    public List<Emprestimo> getValidation(@RequestBody Long id) {
        return service.getValidation(id);
    }

    @PostMapping("/loanpersonalpayed")
    public List<Emprestimo> getValidationPayed(@RequestBody Long id) {
        return service.getValidationPayed(id);
    }

    @PostMapping("/loanpay")
    public boolean getPay(@RequestBody Long id) {
        return service.getPay(id);
    }
}
