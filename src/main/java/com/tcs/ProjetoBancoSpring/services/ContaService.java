package com.tcs.ProjetoBancoSpring.services;

import com.tcs.ProjetoBancoSpring.entities.Conta;
import com.tcs.ProjetoBancoSpring.repositories.ContaRepository;
import com.tcs.ProjetoBancoSpring.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ContaService {

    @Autowired
    private ContaRepository contaRepository;

    public Conta findById(Long id) {
        return contaRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Conta não encontrada!"));
    }

}
