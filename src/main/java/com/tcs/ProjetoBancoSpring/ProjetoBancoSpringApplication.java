package com.tcs.ProjetoBancoSpring;

import com.tcs.ProjetoBancoSpring.entities.Investimento;
import com.tcs.ProjetoBancoSpring.entities.User;
import com.tcs.ProjetoBancoSpring.entities.Conta;
import com.tcs.ProjetoBancoSpring.entities.TipoInvestimento;
import com.tcs.ProjetoBancoSpring.repositories.InvestimentoRepository;
import com.tcs.ProjetoBancoSpring.repositories.UserRepository;
import com.tcs.ProjetoBancoSpring.repositories.ContaRepository;
import com.tcs.ProjetoBancoSpring.repositories.TipoInvestimentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;

import java.util.Date;

@SpringBootApplication
public class ProjetoBancoSpringApplication implements CommandLineRunner {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private InvestimentoRepository InvestimentoRepository;
    @Autowired
    private TipoInvestimentoRepository TipoInvestimentoRepository;
    @Autowired
    private ContaRepository ContaRepository;

	public static void main(String[] args) {
		SpringApplication.run(ProjetoBancoSpringApplication.class, args);
	}

    @Override
    public void run(String... args) throws Exception {
        userRepository.save(new User("one","one","0","0","Oi","111"));
        userRepository.save(new User("two","one","0","0","Oi","111"));
        userRepository.save(new User("three","one","0","0","Oi","111"));
        ContaRepository.save(new Conta(131,122));
        ContaRepository.save(new Conta(31,12));
        ContaRepository.save(new Conta(11,22));
        Date date = new Date();
        InvestimentoRepository.save(new Investimento(date,123.5,1,2));
        TipoInvestimentoRepository.save(new TipoInvestimento("Poupança", 2.7));
    }

}
