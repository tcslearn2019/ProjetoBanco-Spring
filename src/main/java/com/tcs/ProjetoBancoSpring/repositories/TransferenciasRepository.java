
package com.tcs.ProjetoBancoSpring.repositories;

import com.tcs.ProjetoBancoSpring.entities.Transferencias;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

@SpringBootApplication
public interface TransferenciasRepository extends JpaRepository<Transferencias, Long> {
    List<Transferencias> findByContaOrigemIdcontaOrContaDestinoIdconta(Long idOrigem, Long idDestino);
}
