
package com.tcs.ProjetoBancoSpring.controller;

import com.tcs.ProjetoBancoSpring.repositories.ContaRepository;
import com.tcs.ProjetoBancoSpring.repositories.TransferenciasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import com.tcs.ProjetoBancoSpring.entities.Transferencias;
import com.tcs.ProjetoBancoSpring.entities.ParamTransf;
import org.springframework.web.bind.annotation.*;

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
        System.out.println("--------------------");
        System.out.println(paramTransf.getConta());
        System.out.println(paramTransf.getValor());
        System.out.println(paramTransf.getAgencia());
        System.out.println(paramTransf.getIdOrigem());

        return true;
    }

    private void Operacao(String idOrigem, String idDestino){

    }


}


