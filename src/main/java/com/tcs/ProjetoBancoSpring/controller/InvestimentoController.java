package com.tcs.ProjetoBancoSpring.controller;

import com.tcs.ProjetoBancoSpring.entities.Investimento;
import com.tcs.ProjetoBancoSpring.repositories.ContaRepository;
import com.tcs.ProjetoBancoSpring.repositories.InvestimentoRepository;
import com.tcs.ProjetoBancoSpring.repositories.TipoInvestimentoRepository;
import com.tcs.ProjetoBancoSpring.services.InvestimentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/banco")
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*" )
public class InvestimentoController {

    @Autowired
    private InvestimentoRepository InvestimentoRepository;

    @Autowired
    private ContaRepository contaRepository;

    @Autowired
    private TipoInvestimentoRepository tipoInvestimentoRepository;

    @Autowired
    private InvestimentoService investimentoService;

    @GetMapping("/investiment")
    public List<Investimento> getUsers(){
        return InvestimentoRepository.findAll();
    }

    @GetMapping("/investiment/{id}")
    public Investimento getUser(@PathVariable Long id){
        Optional<Investimento> optionalUser = InvestimentoRepository.findById(id);
        return optionalUser.get();
    }

    @DeleteMapping("/investiment/{id}")
    public boolean deleteUser(@PathVariable Long id){
        InvestimentoRepository.deleteById(id);
        return true;
    }

    @PutMapping("/investiment") public Investimento updateUser(@RequestBody Investimento user){
        return InvestimentoRepository.save(user);
    }

    @PostMapping("/investiment")
    public Investimento createUser(@RequestBody Investimento user){
        return InvestimentoRepository.save(user);
    }

    @PostMapping("/new-investiment")
    public Object newInvestiment(@RequestBody Investimento investimento) {
        return investimentoService.newInvestiment(investimento);
    }

    @PostMapping("/refound-investiment")
    public Object refoundInvetiment(@RequestBody long investimento, Double valorRefound) {
        return investimentoService.refoundInvestiment(investimento, valorRefound);
    }
}
