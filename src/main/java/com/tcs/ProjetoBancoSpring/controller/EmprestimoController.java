package com.tcs.ProjetoBancoSpring.controller;

import com.tcs.ProjetoBancoSpring.entities.Conta;
import com.tcs.ProjetoBancoSpring.entities.Emprestimo;
import com.tcs.ProjetoBancoSpring.entities.ParamEmprestimo;
import com.tcs.ProjetoBancoSpring.entities.User;
import com.tcs.ProjetoBancoSpring.repositories.ContaRepository;
import com.tcs.ProjetoBancoSpring.repositories.EmprestimoRepository;
import com.tcs.ProjetoBancoSpring.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/banco")
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*" )
public class EmprestimoController {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private EmprestimoRepository emprestimoRepository;

    @Autowired
    private ContaRepository contaRepository;

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
        if(Double.parseDouble(paramEmprestimo.getValor()) > 0) {
            Optional<User> a = userRepository.findById(Long.parseLong(paramEmprestimo.getIdOrigem()));
            Optional<Conta> destino = contaRepository.findAll().stream().filter(conta ->
                    conta.getFkIdUser().getId() == a.get().getId()).findFirst();
            destino.get().setSaldo(destino.get().getSaldo() + Double.parseDouble(paramEmprestimo.getValor()));
            contaRepository.save(destino.get());
            return emprestimoRepository.save(new Emprestimo(a.get(), new Date(System.currentTimeMillis()), 2.5, Double.parseDouble(paramEmprestimo.getValor()), false));
        }else{
            return null;
        }
    }

    @PostMapping("/loanpersonal")
    public List<Emprestimo> getValidation(@RequestBody Long id){
        List<Emprestimo> listaEmprestimos = emprestimoRepository.findAll().stream().filter(idEmprestimo -> idEmprestimo.getFkIdUser().getId() == id && idEmprestimo.isPago() == false).collect(Collectors.toList());
        return listaEmprestimos;
    }

    @PostMapping("/loanpersonalpayed")
    public List<Emprestimo> getValidationPayed(@RequestBody Long id){
        List<Emprestimo> listaEmprestimos = emprestimoRepository.findAll().stream().filter(idEmprestimo -> idEmprestimo.getFkIdUser().getId() == id && idEmprestimo.isPago() == true).collect(Collectors.toList());
        return listaEmprestimos;
    }

    @PostMapping("/loanpay")
    public boolean getPay(@RequestBody Long id){
        Optional<Conta> contTemp = contaRepository.findById(emprestimoRepository.findById(id).get().getFkIdUser().getId());
        Emprestimo emprestimoTemp = new Emprestimo();
        emprestimoTemp = emprestimoRepository.findById(id).get();
        if(contTemp.get().getSaldo() >= emprestimoTemp.getValorPagar()){
            emprestimoTemp.setPago(true);
            emprestimoTemp.setDataPagamento(new Date(System.currentTimeMillis()));
            emprestimoRepository.save(emprestimoTemp);
            contTemp.get().setSaldo( contTemp.get().getSaldo() - emprestimoTemp.getValorPagar());
            contaRepository.save(contTemp.get());
            return true;
        }
        return false;
    }

}
