package com.tcs.ProjetoBancoSpring.repositories;

import com.tcs.ProjetoBancoSpring.entities.Emprestimo;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.JpaRepository;

@SpringBootApplication
public interface EmprestimoRepository extends JpaRepository<Emprestimo, Long> {


}