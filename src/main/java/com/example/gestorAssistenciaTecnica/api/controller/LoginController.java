/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.gestorAssistenciaTecnica.api.controller;

import com.example.gestorAssistenciaTecnica.api.model.User;
import com.example.gestorAssistenciaTecnica.api.service.UserService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author jefferson
 */
@RestController
@RequestMapping(value = "login")
public class LoginController {

    private final String KEY = "cachorro";

    @Autowired
    UserService userService;

    @RequestMapping(value = "", consumes = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
    public ResponseEntity<User> cadastrarUser(@RequestBody User user) {
        
        System.out.println("username: "+user.getUserName());
        System.out.println("Pass: "+user.getPassworld());

        User u = userService.saveUser(user);

        return new ResponseEntity(user, HttpStatus.CREATED);

    }
    
    

//    @RequestMapping(value = "auth", consumes = MediaType.APPLICATION_JSON_VALUE,
//            method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
//    public LoginResponse auth(@RequestBody User user) {
//
//        User u = userService.buscaUser(user);
//
//        if (u == null) {
//
//            throw new SecurityException("User not found");
//        }
//
//        if (!u.getPassworld().equals(user.getPassworld())) {
//
//            throw new SecurityException("Access Denied!");
//        }
//
//        String token = Jwts.builder()
//                .setSubject(user.getUserName())
//                .signWith(SignatureAlgorithm.HS512, KEY)
//                .setExpiration(new Date(System.currentTimeMillis() + 60 + 60 * 1000))
//                .compact();
//
//        return new LoginResponse(token);
//
//    }

    
}
