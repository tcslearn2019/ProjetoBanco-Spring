package com.tcs.ProjetoBancoSpring.repositories;

import com.tcs.ProjetoBancoSpring.entities.User;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

@SpringBootApplication
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByCpfAndPwd(String cpf, String pwd);

}
