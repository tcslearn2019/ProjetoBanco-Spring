package com.tcs.ProjetoBancoSpring.repositories;

import com.tcs.ProjetoBancoSpring.entities.User;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.JpaRepository;

@SpringBootApplication
public interface UserRepository extends JpaRepository<User, Long> {

}
