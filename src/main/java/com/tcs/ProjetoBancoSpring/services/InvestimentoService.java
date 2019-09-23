package com.tcs.ProjetoBancoSpring.services;

import com.tcs.ProjetoBancoSpring.entities.Conta;
import com.tcs.ProjetoBancoSpring.entities.Investimento;
import com.tcs.ProjetoBancoSpring.repositories.ContaRepository;
import com.tcs.ProjetoBancoSpring.repositories.InvestimentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    public Object refoundInvestiment(long idinvenstimento, Double valorRefound) {
        Investimento inv = investimentoRepository.findById(idinvenstimento).orElse(null);
        if (inv == null) {
            return "Investimento não encontrado.";
        } else {
            if(inv.getValorTemp() < valorRefound) {
                return "Não possui saldo suficiente para receber o valor do investimento!";
            } else {
                inv.setValorTemp(inv.getValorTemp() - valorRefound);
                inv.getFkIdConta().setSaldo(inv.getFkIdConta().getSaldo() + valorRefound);
                return investimentoRepository.save(inv);
            }
        }

    }
}
