package com.tcs.ProjetoBancoSpring.services;

import com.tcs.ProjetoBancoSpring.entities.Login;
import com.tcs.ProjetoBancoSpring.entities.User;
import com.tcs.ProjetoBancoSpring.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User login(Login login) {
        return userRepository.findByCpfAndPwd(login.getLogin(), login.getPwd()).orElse(null);
    }
}
