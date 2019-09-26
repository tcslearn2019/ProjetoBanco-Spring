package com.tcs.ProjetoBancoSpring.repositories;

import com.tcs.ProjetoBancoSpring.entities.Conta;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.JpaRepository;

@SpringBootApplication
public interface ContaRepository extends JpaRepository<Conta, Long>{

    Conta findByFkIdUserId(Long id);

    Conta findByAgenciaAndConta(Long agencia, Long conta);
}
