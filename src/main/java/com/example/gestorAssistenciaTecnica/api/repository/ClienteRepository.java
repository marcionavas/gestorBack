/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.gestorAssistenciaTecnica.api.repository;

import com.example.gestorAssistenciaTecnica.api.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author jefferson
 */
@Repository
public interface ClienteRepository extends JpaRepository<Cliente,Long>{
     
}
