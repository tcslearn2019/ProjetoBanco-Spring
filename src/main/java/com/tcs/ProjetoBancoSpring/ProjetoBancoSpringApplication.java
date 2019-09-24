package com.tcs.ProjetoBancoSpring;


import com.tcs.ProjetoBancoSpring.controller.TransferenciasController;
import com.tcs.ProjetoBancoSpring.entities.*;

import com.tcs.ProjetoBancoSpring.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Component;


@Component
@EnableScheduling
@SpringBootApplication
public class ProjetoBancoSpringApplication implements CommandLineRunner {

    @Autowired
    private com.tcs.ProjetoBancoSpring.repositories.EmprestimoRepository EmprestimoRepository;

    public static void main(String[] args) {
		SpringApplication.run(ProjetoBancoSpringApplication.class, args);
	}

    @Override
    public void run(String... args) throws Exception {

    }

}
