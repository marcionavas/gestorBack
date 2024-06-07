/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.gestorAssistenciaTecnica.api.controller;

import com.example.gestorAssistenciaTecnica.api.model.Cliente;
import com.example.gestorAssistenciaTecnica.api.service.ClienteService;
import com.example.gestorAssistenciaTecnica.api.util.exceptions.TelefoneException;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author jefferson
 */
@RestController
@RequestMapping(value = "/cliente")
public class ClienteController {

    @Autowired
    ClienteService clienteService;

    @RequestMapping(method = RequestMethod.POST, value = "", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity cadastrarCliente(@RequestBody Cliente cliente) {

        try {
            clienteService.salvarCliente(cliente);
        } catch (TelefoneException e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(cliente, HttpStatus.CREATED);

    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Cliente> carregarClienteById(@PathVariable Long id) {

        Cliente cli = clienteService.buscaPorID(id);

        if (cli == null) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity(cli, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Collection<Cliente>> carregarTodosClientes() {

        Collection<Cliente> todos;
        todos = clienteService.listaTodosClientes();

        return new ResponseEntity<>(todos, HttpStatus.OK);
    }

}
