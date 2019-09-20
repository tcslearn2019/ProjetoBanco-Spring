package com.tcs.ProjetoBancoSpring.services;

import com.tcs.ProjetoBancoSpring.entities.Emprestimo;
import com.tcs.ProjetoBancoSpring.repositories.EmprestimoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@EnableScheduling
public class EmprestimoScheduled {

    @Autowired
    private EmprestimoRepository EmprestimoRepository;

    @Scheduled(cron = "0 0/1 * * * ?")
    public void EmprestimoJurosCalculo() {
        calcularJuros(EmprestimoRepository.findAll());
    }

    private void calcularJuros(List<Emprestimo> listRepository){
        for(Emprestimo i : listRepository){
            i.setValorPagar((i.getValorPagar() * (i.getJuros()/100)) + i.getValorPagar());
            EmprestimoRepository.save(i);
        }
    }

}
