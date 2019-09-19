
package com.tcs.ProjetoBancoSpring;

import com.tcs.ProjetoBancoSpring.entities.*;
import com.tcs.ProjetoBancoSpring.repositories.*;
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
    @Autowired
    private TransferenciasRepository TransferenciaRepository;


    public static void main(String[] args) {
		SpringApplication.run(ProjetoBancoSpringApplication.class, args);
	}

    @Override
    public void run(String... args) throws Exception {
        //userRepository.save(new User("one","one","0","0","Oi","111"));
       // userRepository.save(new User("two","one","0","0","Oi","111"));
       // User a = new User("three","one","123","456","Oi","111");
       // userRepository.save(a);
        //ContaRepository.save(new Conta(new User("three","one","123","456","Oi","111"),131,122,0));
        //ContaRepository.save(new Conta(3,11,22,311));
        //ContaRepository.save(new Conta(2,31,12,120));
       // Date date = new Date();
       // InvestimentoRepository.save(new Investimento(date,123.5,1,2));
       // TipoInvestimentoRepository.save(new TipoInvestimento("Poupança", 2.7));
        //.save(new Transferencias(123,321,150));

    }

}
