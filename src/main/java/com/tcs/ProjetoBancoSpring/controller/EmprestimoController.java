package com.tcs.ProjetoBancoSpring.controller;

import com.tcs.ProjetoBancoSpring.entities.Emprestimo;
import com.tcs.ProjetoBancoSpring.entities.ParamEmprestimo;
import com.tcs.ProjetoBancoSpring.entities.User;
import com.tcs.ProjetoBancoSpring.repositories.EmprestimoRepository;
import com.tcs.ProjetoBancoSpring.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/banco")
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*" )
public class EmprestimoController {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private EmprestimoRepository emprestimoRepository;

    @GetMapping("/loanpersonal")
    public List<Emprestimo> getEmprestimoPessoal(@RequestBody long idParam){
        System.out.println("Entrando!");
        System.out.println(idParam);
        emprestimoRepository.findAll().stream().filter(id -> id.getFkIdUser().getId() == idParam).forEach(System.out::println);
        return null;
    }

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

    @PutMapping("/loan") public Emprestimo updateEmprestimo(@RequestBody Emprestimo paramEmprestimo){
        return emprestimoRepository.save(paramEmprestimo);
    }

    @PostMapping("/loan")
    public Emprestimo createEmprestimo(@RequestBody ParamEmprestimo paramEmprestimo){
        Optional<User> a = userRepository.findById(Long.parseLong(paramEmprestimo.getIdOrigem()));
        return emprestimoRepository.save(new Emprestimo(a.get(),new Date(System.currentTimeMillis()),2.5,Double.parseDouble(paramEmprestimo.getValor())));
    }

    @PostMapping("/loanvalidation")
    public boolean getValidation(@RequestBody Long id){
        return false;
    }


}
