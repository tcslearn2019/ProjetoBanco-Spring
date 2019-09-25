package com.tcs.ProjetoBancoSpring.controller;

import com.tcs.ProjetoBancoSpring.entities.TipoInvestimento;
import com.tcs.ProjetoBancoSpring.services.TipoInvestimentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/banco")
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*" )
public class TipoInvestimentoController {

    @Autowired
    private TipoInvestimentoService service;

    @GetMapping("/type/investiment")
    public List<TipoInvestimento> getUsers(){
        return service.findAll();
    }

    @GetMapping("/type/investiment/{id}")
    public TipoInvestimento getUser(@PathVariable Long id){
        return service.findById(id);
    }

    @DeleteMapping("/type/investiment/{id}")
    public boolean deleteUser(@PathVariable Long id){
        return service.deleteUser(id);
    }

    @PutMapping("/type/investiment")
    public TipoInvestimento updateUser(@RequestBody TipoInvestimento tipoInvestimento){
        return service.updateUser(tipoInvestimento);
    }

    @PostMapping("/type/investiment")
    public TipoInvestimento createUser(@RequestBody TipoInvestimento tipoInvestimento){
        return service.save(tipoInvestimento);
    }
}
