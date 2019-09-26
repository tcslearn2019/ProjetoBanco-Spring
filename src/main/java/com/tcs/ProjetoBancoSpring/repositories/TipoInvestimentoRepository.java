package com.tcs.ProjetoBancoSpring.repositories;

import com.tcs.ProjetoBancoSpring.entities.TipoInvestimento;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

@SpringBootApplication
public interface TipoInvestimentoRepository extends JpaRepository<TipoInvestimento, Long> {
    List<TipoInvestimento> findByAtivo(Boolean b);
}
