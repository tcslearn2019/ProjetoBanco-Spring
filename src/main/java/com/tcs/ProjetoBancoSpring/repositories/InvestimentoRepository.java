package com.tcs.ProjetoBancoSpring.repositories;

import com.tcs.ProjetoBancoSpring.entities.Investimento;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.JpaRepository;

@SpringBootApplication
public interface InvestimentoRepository extends JpaRepository<Investimento, Long> {

}
