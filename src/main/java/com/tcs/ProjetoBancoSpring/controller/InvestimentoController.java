package com.tcs.ProjetoBancoSpring.controller;

import com.tcs.ProjetoBancoSpring.entities.Investimento;
import com.tcs.ProjetoBancoSpring.entities.ParamInvestimento;
import com.tcs.ProjetoBancoSpring.services.InvestimentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/banco")
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*" )
public class InvestimentoController {

    @Autowired
    private InvestimentoService service;

    @GetMapping("/investiment")
    public List<Investimento> getInvestimentos(){
        return service.findAll();
    }

    @GetMapping("/investiment/{id}")
    public Investimento getInvestimento(@PathVariable Long id){
        return service.findById(id);
    }

    @DeleteMapping("/investiment/{id}")
    public boolean deleteInvestimento(@PathVariable Long id){
        return service.deleteById(id);
    }

    @PutMapping("/investiment")
    public Investimento updateInvestimento(@RequestBody Investimento investimento){
        return service.update(investimento);
    }

    @PostMapping("/investimentnew")
    public boolean getValidation(@RequestBody ParamInvestimento paramInvestimento){
        return service.createInvestiment(paramInvestimento);
    }

    @PostMapping("/investimentbyid")
    public List<Investimento> getListInvestimento(@RequestBody Long id){
        return service.findByIdUserAtivo(id);
    }

    @PostMapping("/investimentbyidresgatados")
    public List<Investimento> getListInvestimentoResgatados(@RequestBody Long id){
        return service.findByIdUserInativo(id);
    }

    @PostMapping("/resgateinvestimentbyid")
    public boolean updateInvestimentoById(@RequestBody Investimento investimento){
        return service.refound(investimento);
    }


}
