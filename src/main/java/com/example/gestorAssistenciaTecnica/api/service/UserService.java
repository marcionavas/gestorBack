/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.gestorAssistenciaTecnica.api.service;

import com.example.gestorAssistenciaTecnica.api.model.User;
import com.example.gestorAssistenciaTecnica.api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author jefferson
 */
@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public User findByUserName(String userName) {

        return userRepository.findByUserName(userName);

    }

    public User saveUser(User u) {
        return userRepository.save(u);
    }

    public User buscaUser(User u) {
        return userRepository.findByUserName(u.getUserName());
    }
}
