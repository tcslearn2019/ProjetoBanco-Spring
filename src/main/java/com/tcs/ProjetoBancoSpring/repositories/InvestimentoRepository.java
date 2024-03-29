package com.tcs.ProjetoBancoSpring.repositories;

import com.tcs.ProjetoBancoSpring.entities.Investimento;
import com.tcs.ProjetoBancoSpring.entities.TipoInvestimento;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

@SpringBootApplication
public interface InvestimentoRepository extends JpaRepository<Investimento, Long> {

    List<Investimento> findAllByFkIdTipoInvestimento(TipoInvestimento nome);

    List<Investimento> findByFkIdContaFkIdUserIdAndAtivo(Long id, Boolean ativo);

}
