package com.tcs.ProjetoBancoSpring.controller;

import com.tcs.ProjetoBancoSpring.entities.TipoInvestimento;
import com.tcs.ProjetoBancoSpring.repositories.TipoInvestimentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/banco")
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*" )
public class TipoInvestimentoController {
    @Autowired
    private TipoInvestimentoRepository TipoInvestimentoRepository;

    @GetMapping("/type/investiment")
    public List<TipoInvestimento> getUsers(){
        return TipoInvestimentoRepository.findAll();
    }

    @GetMapping("/type/investiment/{id}")
    public TipoInvestimento getUser(@PathVariable Long id){
        Optional<TipoInvestimento> optionalUser = TipoInvestimentoRepository.findById(id);
        return optionalUser.get();
    }

    @DeleteMapping("/type/investiment/{id}")
    public boolean deleteUser(@PathVariable Long id){
        TipoInvestimentoRepository.deleteById(id);
        return true;
    }

    @PutMapping("/type/investiment") public TipoInvestimento updateUser(@RequestBody TipoInvestimento user){
        return TipoInvestimentoRepository.save(user);
    }

    @PostMapping("/type/investiment")
    public TipoInvestimento createUser(@RequestBody TipoInvestimento user){
        return TipoInvestimentoRepository.save(user);
    }
}
