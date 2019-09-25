package com.tcs.ProjetoBancoSpring.services;

import com.tcs.ProjetoBancoSpring.entities.TipoInvestimento;
import com.tcs.ProjetoBancoSpring.repositories.TipoInvestimentoRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static java.util.Objects.nonNull;

@Service
@Transactional
public class TipoInvestimentoService {

    @Autowired
    private TipoInvestimentoRepository repository;

    public List<TipoInvestimento> findAll() {
        return repository.findAll();
    }

    public TipoInvestimento findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public boolean deleteUser(Long id) {
        TipoInvestimento tipoInvestimento = findById(id);
        if(nonNull(tipoInvestimento)) {
            repository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

    public TipoInvestimento updateUser(TipoInvestimento tipoInvestimento) {
        TipoInvestimento tipInvestimento = findById(tipoInvestimento.getIdinv());
        BeanUtils.copyProperties(tipInvestimento, tipInvestimento, "idinv" );
        return repository.save(tipInvestimento);
    }

    public TipoInvestimento save(TipoInvestimento tipoInvestimento) {
        return repository.save(tipoInvestimento);
    }
}

