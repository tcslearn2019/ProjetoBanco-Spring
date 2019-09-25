package com.tcs.ProjetoBancoSpring.services;

import com.tcs.ProjetoBancoSpring.entities.Conta;
import com.tcs.ProjetoBancoSpring.entities.Login;
import com.tcs.ProjetoBancoSpring.entities.User;
import com.tcs.ProjetoBancoSpring.repositories.ContaRepository;
import com.tcs.ProjetoBancoSpring.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Random;

import static java.util.Objects.nonNull;

@Service
@Transactional
public class UserService {

    @Autowired
    private UserRepository repository;

    @Autowired
    private ContaRepository contaRepository;

    public User login(Login login) {
        return repository.findByCpfAndPwd(login.getLogin(), login.getPwd()).orElse(null);
    }

    public User findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public List<User> findAll() {
        return repository.findAll();
    }

    public boolean deleteById(Long id) {
        User user = findById(id);
        if(Objects.nonNull(user)) {
            repository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

    public User save(User user) {
        return repository.save(user);
    }

    public User createUser(User user) {
        Random rd = new Random();
        user.setAdministrador(false);
        repository.save(user);
        System.out.println(user);
        contaRepository.save(new Conta(user, rd.nextInt(999999), 4570, 0));
        return user;
    }
}
