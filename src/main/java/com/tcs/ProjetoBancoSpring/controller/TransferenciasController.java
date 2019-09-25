
package com.tcs.ProjetoBancoSpring.controller;

import com.tcs.ProjetoBancoSpring.entities.ParamTransf;
import com.tcs.ProjetoBancoSpring.entities.RetornoMovimentacao;
import com.tcs.ProjetoBancoSpring.entities.Transferencias;
import com.tcs.ProjetoBancoSpring.services.TransferenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/banco")
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
public class TransferenciasController {

    @Autowired
    private TransferenciaService service;

    @GetMapping("/transferencias")
    public List<Transferencias> getTransferencias() {
        return service.findAll();
    }

    @GetMapping("/transferencias/{id}")
    public Transferencias getTransferencia(@PathVariable Long id) {
        return service.findById(id);
    }

    @DeleteMapping("/transferencias/{id}")
    public boolean deleteTransferencia(@PathVariable Long id) {
        return service.deleteById(id);
    }

    @PutMapping("/transferencias")
    public Transferencias updateTransferencia(@RequestBody Transferencias transferencias) {
        return service.update(transferencias);
    }

    @PostMapping("/transferencias")
    public Transferencias createTransferencia(@RequestBody Transferencias transferencia) {
        return service.save(transferencia);
    }

    @PostMapping("/transferenciabyid")
    public List<RetornoMovimentacao> getListEmprestimos(@RequestBody Long id) {
        return service.listEmprestimo(id);
    }

    @PostMapping("/transferencia")
    public boolean getValidation(@RequestBody ParamTransf paramTransf) {
        return service.getValidation(paramTransf);
    }
}


