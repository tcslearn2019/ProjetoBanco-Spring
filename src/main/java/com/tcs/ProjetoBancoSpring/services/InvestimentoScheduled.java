package com.tcs.ProjetoBancoSpring.services;

import com.tcs.ProjetoBancoSpring.entities.Investimento;
import com.tcs.ProjetoBancoSpring.repositories.InvestimentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@EnableScheduling
public class InvestimentoScheduled {

    @Autowired
    private InvestimentoRepository investimentoRepository;

    @Scheduled(cron = "0 0/1 * * * ?")
    public void CalcularInvestimento() {
        List<Investimento> investimentos = investimentoRepository.findAll();

        investimentos.forEach(investimento -> {
            if(investimento.isAtivo()) {
                double juros = investimento.getFkIdTipoInvestimento().getJuros();
                double valor = (investimento.getValor() / 100) * juros;
                investimento.setValorTemp(investimento.getValorTemp() + valor);
                investimentoRepository.save(investimento);
            }
        });

    }
}
