package com.tcs.ProjetoBancoSpring.services;

import com.tcs.ProjetoBancoSpring.entities.Conta;
import com.tcs.ProjetoBancoSpring.entities.Investimento;
import com.tcs.ProjetoBancoSpring.repositories.ContaRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

import static java.util.Objects.nonNull;

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

    public List<Conta> findAll() {
        return repository.findAll();
    }

    public boolean deleteById(Long id) {
        Conta conta = findById(id);
        if (nonNull(conta)) {
            repository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

    public Conta updateConta(Conta conta) {
        Conta co = findById(conta.getIdconta());
        BeanUtils.copyProperties(conta, co, "idconta", "fkIdUser");
        return repository.save(co);
    }

    public Conta createAccount(Conta conta) {
        return repository.save(conta);
    }

    public Conta findByUserId(Long id) {
        return repository.findByFkIdUserId(id);
    }
}
