package com.tcs.ProjetoBancoSpring.services;

import com.tcs.ProjetoBancoSpring.entities.Conta;
import com.tcs.ProjetoBancoSpring.repositories.ContaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ContaService {

    @Autowired
    private ContaRepository repository;

    public Conta findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public Conta findByIdUser(Long id) {
        return repository.findByFkIdUserId(id);
    }

    public Conta save(Conta conta) {
        return repository.save(conta);
    }
}
