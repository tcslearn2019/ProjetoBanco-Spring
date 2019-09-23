package com.tcs.ProjetoBancoSpring.services;

import com.tcs.ProjetoBancoSpring.entities.Conta;
import com.tcs.ProjetoBancoSpring.entities.Investimento;
import com.tcs.ProjetoBancoSpring.repositories.InvestimentoRepository;
import com.tcs.ProjetoBancoSpring.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class InvestimentoService {

    @Autowired
    private ContaService contaService;

    @Autowired
    private InvestimentoRepository investimentoRepository;

    public Investimento findById(Long id) {
        return investimentoRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Investimento não encontrado!"));
    }

    public Investimento newInvestiment(Investimento investimento) {
        Conta conta = contaService.findById(investimento.getFkIdConta().getConta());
        conta.validarSaldoParaInvestimento(investimento.getValor());
        return investimentoRepository.save(investimento);
    }

    public Investimento refoundInvestiment(Long idinvestimento, Double valorRefound) {
        Investimento inv = findById(idinvestimento);
        inv.validateRefound(valorRefound);
        inv.setValorTemp(inv.getValorTemp() - valorRefound);
        inv.getFkIdConta().setSaldo(inv.getFkIdConta().getSaldo() + valorRefound);
        return investimentoRepository.save(inv);

    }

    public Investimento addInvestiment(Long idinvestimento, Double addValor) {
        Investimento inv = findById(idinvestimento);
        Conta conta = inv.getFkIdConta();
        conta.validarSaldoParaInvestimento(addValor);
        inv.setValorTemp(inv.getValorTemp() + addValor);
        inv.getFkIdConta().setSaldo(inv.getFkIdConta().getSaldo() - addValor);
        return investimentoRepository.save(inv);
    }
}
