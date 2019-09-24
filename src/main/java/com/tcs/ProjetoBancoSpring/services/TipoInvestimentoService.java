package com.tcs.ProjetoBancoSpring.services;

import com.tcs.ProjetoBancoSpring.entities.TipoInvestimento;
import com.tcs.ProjetoBancoSpring.repositories.TipoInvestimentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class TipoInvestimentoService {

    @Autowired
    private TipoInvestimentoRepository repository;

    public TipoInvestimento findById(Long id) {
        return repository.findById(id).orElse(null);
    }

}
