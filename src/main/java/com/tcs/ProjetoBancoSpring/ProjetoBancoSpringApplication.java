
package com.tcs.ProjetoBancoSpring;

import com.tcs.ProjetoBancoSpring.controller.TransferenciasController;
import com.tcs.ProjetoBancoSpring.entities.*;
import com.tcs.ProjetoBancoSpring.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Component
@EnableScheduling
@SpringBootApplication
public class ProjetoBancoSpringApplication implements CommandLineRunner {
    @Autowired
    private EmprestimoRepository EmprestimoRepository;

    public static void main(String[] args) {
		SpringApplication.run(ProjetoBancoSpringApplication.class, args);
	}

    @Override
    public void run(String... args) throws Exception {
    }


    @Scheduled(cron = "0 0/1 * * * ?")
    public void teste() {
        System.out.println("Entrando!");
        calcularJuros(EmprestimoRepository.findAll());
    }

    private void calcularJuros(List<Emprestimo> listRepository){
        for(Emprestimo i : listRepository){
            i.setValorPagar((i.getValorPagar() * 0.25) + i.getValorPagar());
            EmprestimoRepository.save(i);
        }
        System.out.println("Recalculando");

    }

}
