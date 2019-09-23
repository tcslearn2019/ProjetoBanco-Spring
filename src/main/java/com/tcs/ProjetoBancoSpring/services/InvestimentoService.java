package com.tcs.ProjetoBancoSpring.services;

import com.tcs.ProjetoBancoSpring.entities.Conta;
import com.tcs.ProjetoBancoSpring.entities.Investimento;
import com.tcs.ProjetoBancoSpring.entities.TipoInvestimento;
import com.tcs.ProjetoBancoSpring.repositories.ContaRepository;
import com.tcs.ProjetoBancoSpring.repositories.InvestimentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class InvestimentoService {

    @Autowired
    private ContaRepository contaRepository;

    @Autowired
    private InvestimentoRepository investimentoRepository;

    public Object newInvestiment(Investimento investimento) {
        Optional<Conta> conta = contaRepository.findById(investimento.getFkIdConta().getConta());
        if(conta.get().getSaldo() < investimento.getValor()) {
            return "Não possui saldo suficiente para realizar o investimento!";
        } else {
            return investimentoRepository.save(investimento);
        }
    }
}
