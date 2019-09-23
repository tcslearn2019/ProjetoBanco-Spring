package com.tcs.ProjetoBancoSpring.controller;

import com.tcs.ProjetoBancoSpring.entities.Investimento;
import com.tcs.ProjetoBancoSpring.entities.ParamInvestimento;
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
    public List<Investimento> getInvestimentos(){
        return InvestimentoRepository.findAll();
    }

    @GetMapping("/investiment/{id}")
    public Investimento getInvestimento(@PathVariable Long id){
        Optional<Investimento> optionalUser = InvestimentoRepository.findById(id);
        return optionalUser.get();
    }

    @DeleteMapping("/investiment/{id}")
    public boolean deleteInvestimento(@PathVariable Long id){
        InvestimentoRepository.deleteById(id);
        return true;
    }

    @PutMapping("/investiment") public Investimento updateInvestimento(@RequestBody Investimento user){
        return InvestimentoRepository.save(user);
    }

    @PostMapping("/investiment")
    public Investimento createInvestimento(@RequestBody Investimento user){
        return InvestimentoRepository.save(user);
    }

    @PostMapping("/investimentnew")
    public boolean getValidation(@RequestBody ParamInvestimento paramInvestimento){
        System.out.println(paramInvestimento.getIdInvestimento() + " " + paramInvestimento.getValor());
        return false;
    }


    @PostMapping("/new-investiment")
    public Object newInvestiment(@RequestBody Investimento investimento) {
        return investimentoService.newInvestiment(investimento);
    }

    @PostMapping("/refound-investiment/{idinvenstimento}")
    public Object refoundInvetiment(@PathVariable("idinvenstimento") Long idinvenstimento, @RequestParam Double valorRefound) {
        return investimentoService.refoundInvestiment(idinvenstimento, valorRefound);
    }

    @PostMapping("add-investiment/{idinvestimento}")
    public Object addInvestiment(@PathVariable("idinvestimento") Long idinvestimento, @RequestParam Double attValorInv) {
        return investimentoService.addInvestiment(idinvestimento, attValorInv);
    }
}
