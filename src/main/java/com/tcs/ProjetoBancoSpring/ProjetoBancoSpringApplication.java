package com.tcs.ProjetoBancoSpring;

import com.tcs.ProjetoBancoSpring.repositories.UserRepository;
import com.tcs.ProjetoBancoSpring.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.CommandLineRunner;
@SpringBootApplication
public class ProjetoBancoSpringApplication implements CommandLineRunner {
    @Autowired
    private UserRepository userRepository;

	public static void main(String[] args) {
		SpringApplication.run(ProjetoBancoSpringApplication.class, args);
	}

    @Override
    public void run(String... args) throws Exception {
        userRepository.save(new User("one","one","0","0","Oi","111"));
        userRepository.save(new User("two","one","0","0","Oi","111"));
        userRepository.save(new User("three","one","0","0","Oi","111"));
    }

}
