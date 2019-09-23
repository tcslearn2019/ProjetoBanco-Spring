
package com.tcs.ProjetoBancoSpring.controller;

import com.tcs.ProjetoBancoSpring.entities.*;
import com.tcs.ProjetoBancoSpring.repositories.ContaRepository;
import com.tcs.ProjetoBancoSpring.repositories.EmprestimoRepository;
import com.tcs.ProjetoBancoSpring.repositories.TransferenciasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/banco")
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*" )
public class TransferenciasController {

    @Autowired
    private ContaRepository contaRepository;

    @Autowired
    private TransferenciasRepository transferenciasRepository;

    @Autowired
    private EmprestimoRepository emprestimoRepository;


    @GetMapping("/transferencias")
    public List<Transferencias> getTransferencias(){
        return transferenciasRepository.findAll();
    }

    @GetMapping("/transferencias/{id}")
    public Transferencias getTransferencia(@PathVariable Long id){
        Optional<Transferencias> optionalUser = transferenciasRepository.findById(id);
        return optionalUser.get();
    }

    @DeleteMapping("/transferencias/{id}")
    public boolean deleteTransferencia(@PathVariable Long id){
        transferenciasRepository.deleteById(id);
        return true;
    }

    @PutMapping("/transferencias")
    public Transferencias updateTransferencia(@RequestBody Transferencias user){
        return transferenciasRepository.save(user);
    }

    @PostMapping("/transferencias")
    public Transferencias createTransferencia(@RequestBody Transferencias user){
        return transferenciasRepository.save(user);
    }

    @PostMapping("/transferenciabyid")
    public List<RetornoMovimentacao> getListEmprestimos(@RequestBody Long id){
        List<Transferencias> listaTransferencias  = transferenciasRepository.findAll().stream().filter(idParam ->
                id == idParam.getIdContaOrigem() || id == idParam.getIdContaDestino()).collect(Collectors.toList());

        List<RetornoMovimentacao> listaReternoMovimentacao = new ArrayList<RetornoMovimentacao>();

        for(Transferencias i : listaTransferencias){
            listaReternoMovimentacao.add(new RetornoMovimentacao(contaRepository.findById(i.getIdContaOrigem()).get().getAgencia(),
                    contaRepository.findById(i.getIdContaDestino()).get().getAgencia(),
                    contaRepository.findById(i.getIdContaOrigem()).get().getConta(),
                    contaRepository.findById(i.getIdContaDestino()).get().getConta(),
                    i.getValor(), i.getDataTransferencia()));
        }
        return listaReternoMovimentacao;
    }

    @PostMapping("/transferencia")
    public boolean getValidation(@RequestBody ParamTransf paramTransf){
        Optional<Conta> Origem = contaRepository.findAll().stream().filter(conta ->
                Long.toString(conta.getFkIdUser().getId()).equals(paramTransf.getIdOrigem())).findFirst();

        Optional<Conta> Destino = contaRepository.findAll().stream().filter(conta ->
                Long.toString(conta.getConta()).equals(paramTransf.getConta())
                && Long.toString(conta.getAgencia()).equals(paramTransf.getAgencia())).findFirst();

        return Operacao(Origem.get().getIdconta(),Destino.get().getIdconta(), Double.parseDouble(paramTransf.getValor()));
    }

    private boolean Operacao(long idOrigem, long idDestino, Double valorTransfer){
        if(contaRepository.findById(idOrigem).get().getSaldo() >= valorTransfer && valorTransfer > 0){
            Conta temporario = new Conta();
            temporario = contaRepository.findById(idDestino).get();
            temporario.setSaldo(temporario.getSaldo() + valorTransfer);
            contaRepository.save(temporario);
            temporario = contaRepository.findById(idOrigem).get();
            temporario.setSaldo(temporario.getSaldo() - valorTransfer);
            contaRepository.save(temporario);
            Transferencias transf = new Transferencias(idOrigem,idDestino,valorTransfer,new Date(System.currentTimeMillis()));
            transferenciasRepository.save(transf);
            return true;
        }
        else {
            return false;
        }
    }

}


