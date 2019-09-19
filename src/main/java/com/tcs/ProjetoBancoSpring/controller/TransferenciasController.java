
package com.tcs.ProjetoBancoSpring.controller;

import com.tcs.ProjetoBancoSpring.entities.Conta;
import com.tcs.ProjetoBancoSpring.entities.User;
import com.tcs.ProjetoBancoSpring.repositories.ContaRepository;
import com.tcs.ProjetoBancoSpring.repositories.TransferenciasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import com.tcs.ProjetoBancoSpring.entities.Transferencias;
import com.tcs.ProjetoBancoSpring.entities.ParamTransf;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/banco")
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*" )
public class TransferenciasController {

    @Autowired
    private ContaRepository contaRepository;

    @Autowired
    private TransferenciasRepository transferenciasRepository;

    @Autowired
    private com.tcs.ProjetoBancoSpring.repositories.InvestimentoRepository emprestimoRepository;

    @GetMapping("/transferencias")
    public List<Transferencias> getUsers(){
        return transferenciasRepository.findAll();
    }

    @GetMapping("/transferencias/{id}")
    public Transferencias getUser(@PathVariable Long id){
        Optional<Transferencias> optionalUser = transferenciasRepository.findById(id);
        return optionalUser.get();
    }

    @DeleteMapping("/transferencias/{id}")
    public boolean deleteUser(@PathVariable Long id){
        transferenciasRepository.deleteById(id);
        return true;
    }

    @PutMapping("/transferencias")
    public Transferencias updateUser(@RequestBody Transferencias user){
        return transferenciasRepository.save(user);
    }

    @PostMapping("/transferencias")
    public Transferencias createUser(@RequestBody Transferencias user){
        return transferenciasRepository.save(user);
    }

    @PostMapping("/transferencia")
    public boolean getValidation(@RequestBody ParamTransf paramTransf){
        Optional<Conta> Origem = contaRepository.findAll().stream().filter(conta ->
                Long.toString(conta.getFkIdUser().getId()).equals(paramTransf.getIdOrigem())).findFirst();

        Optional<Conta> Destino = contaRepository.findAll().stream().filter(conta ->
                Long.toString(conta.getConta()).equals(paramTransf.getConta())
                && Long.toString(conta.getAgencia()).equals(paramTransf.getAgencia())).findFirst();

        return Operacao(Origem.get().getIdconta(),Destino.get().getIdconta(), Long.parseLong(paramTransf.getValor()));
    }

    private boolean Operacao(long idOrigem, long idDestino, long valorTransfer){
        if(contaRepository.findById(idOrigem).get().getSaldo() > valorTransfer){
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


