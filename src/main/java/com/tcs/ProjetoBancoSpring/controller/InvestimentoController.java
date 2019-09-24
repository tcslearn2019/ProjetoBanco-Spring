package com.tcs.ProjetoBancoSpring.controller;

import com.tcs.ProjetoBancoSpring.entities.Conta;
import com.tcs.ProjetoBancoSpring.entities.Investimento;
import com.tcs.ProjetoBancoSpring.entities.ParamInvestimento;
import com.tcs.ProjetoBancoSpring.repositories.ContaRepository;
import com.tcs.ProjetoBancoSpring.repositories.InvestimentoRepository;
import com.tcs.ProjetoBancoSpring.repositories.TipoInvestimentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/banco")
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*" )
public class InvestimentoController {

    @Autowired
    private InvestimentoRepository investimentoRepository;

    @Autowired
    private ContaRepository contaRepository;

    @Autowired
    private TipoInvestimentoRepository tipoInvestimentoRepository;


    @GetMapping("/investiment")
    public List<Investimento> getInvestimentos(){
        return investimentoRepository.findAll();
    }

    @GetMapping("/investiment/{id}")
    public Investimento getInvestimento(@PathVariable Long id){
        Optional<Investimento> optionalUser = investimentoRepository.findById(id);
        return optionalUser.get();
    }

    @DeleteMapping("/investiment/{id}")
    public boolean deleteInvestimento(@PathVariable Long id){
        investimentoRepository.deleteById(id);
        return true;
    }

    @PutMapping("/investiment") public Investimento updateInvestimento(@RequestBody Investimento user){
        return investimentoRepository.save(user);
    }

    @PostMapping("/investimentnew")
    public boolean getValidation(@RequestBody ParamInvestimento paramInvestimento){
        Optional <Conta> contaUser = contaRepository.findAll().stream().filter(idConta ->
                idConta.getFkIdUser().getId() == paramInvestimento.getIduser()).findFirst();


        if(contaUser.get().getSaldo() >= paramInvestimento.getValor() && paramInvestimento.getValor() > 0){
                investimentoRepository.save(new Investimento(new Date(System.currentTimeMillis()),
                    contaUser.get(), tipoInvestimentoRepository.findById(paramInvestimento.getIdinv()).get(),
                        paramInvestimento.getValor(), paramInvestimento.getValor() , true));
                contaUser.get().setSaldo(contaUser.get().getSaldo() - paramInvestimento.getValor());
            contaRepository.save(contaUser.get());
            return true;
        }
        else{
            return false;
        }
    }

    @PostMapping("/investimentbyid")
    public List<Investimento> getListInvestimento(@RequestBody Long id){
        List<Investimento> listaEmprestimos = investimentoRepository.findAll().stream().filter(idInvestimento -> idInvestimento.getFkIdConta().getFkIdUser().getId() == id && idInvestimento.isAtivo()).collect(Collectors.toList());
        return listaEmprestimos;
    }

    @PostMapping("/investimentbyidresgatados")
    public List<Investimento> getListInvestimentoResgatados(@RequestBody Long id){
        List<Investimento> listaEmprestimos = investimentoRepository.findAll().stream().filter(idInvestimento -> idInvestimento.getFkIdConta().getFkIdUser().getId() == id && !idInvestimento.isAtivo()).collect(Collectors.toList());
        return listaEmprestimos;
    }

    @PostMapping("/resgateinvestimentbyid")
    public boolean updateInvestimentoById(@RequestBody Investimento investimento){
        investimento.setAtivo(false);
        investimento.setDataResgate(new Date(System.currentTimeMillis()));
        investimentoRepository.save(investimento);
        Optional <Conta> contaInvestimento = contaRepository.findById(investimento.getFkIdConta().getIdconta());
        contaInvestimento.get().setSaldo(investimento.getValorTemp() + contaInvestimento.get().getSaldo());
        contaRepository.save(contaInvestimento.get());
        return true;
    }


}
