/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.gestorAssistenciaTecnica.api.repository;

import com.example.gestorAssistenciaTecnica.api.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author jefferson
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

//    @Query(value = "select u from User u where u.username=:uname")
//    public User findByUserName(@Param("uname") String userName);
    
    public User findByUserName(String username);
}
