/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.gestorAssistenciaTecnica.api.service;

import com.example.gestorAssistenciaTecnica.api.model.Cliente;
import com.example.gestorAssistenciaTecnica.api.model.Telefone;
import com.example.gestorAssistenciaTecnica.api.repository.ClienteRepository;
import com.example.gestorAssistenciaTecnica.api.util.exceptions.TelefoneException;
import java.util.Iterator;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author jefferson
 */
@Service
public class ClienteService {

    @Autowired
    ClienteRepository clienteRepository;

    public Cliente salvarCliente(Cliente cli) throws TelefoneException {
        validarTelefones(cli);
        return clienteRepository.save(cli);
    }

    public List<Cliente> listaTodosClientes() {
        return clienteRepository.findAll();

    }

    public void excluirCliente(Cliente cli) {
        //Criar regras para exclusão lógica
    }

    public Cliente buscaPorID(long id) {
        return clienteRepository.findById(id).get();
    }

    public Cliente editar(Cliente cli) {
        return clienteRepository.save(cli);
    }

    /**
     * Remove todos telefones que sejam strings vazias,
     *
     * @throws Telefone Exception se receber telefone com letras ou caracteres
     * especiais
     * @throws Telefone Exception se não houver nenhum telefone cadastrado
     */
    private void validarTelefones(Cliente cli) throws TelefoneException {

        for (Iterator<Telefone> iter = cli.getTelefones().iterator(); iter.hasNext();) {

            String telefone = iter.next().getTelefone();
            if (telefone == null) {
                iter.remove();
                continue;
            }

            telefone = telefone.replaceAll("\\s", "");

            if (telefone.equals("")) {
                iter.remove();
                continue;
            } else if (telefone.length() >= 10) {

                if (telefone.length() > 11) {
                    throw new TelefoneException("Número maior que 11 dígitos");
                }
            } else {
                throw new TelefoneException("Número menor que 10 dígitos");
            }

            try {
                double x = Double.parseDouble(telefone);

            } catch (NumberFormatException e) {
                throw new TelefoneException("Número inválido ", telefone);
            }
        }
        if (cli.getTelefones().isEmpty()) {
            throw new TelefoneException("Nenhum telefone válido");
        }
    }

}
