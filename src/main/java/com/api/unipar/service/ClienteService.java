package com.api.unipar.service;

import com.api.unipar.entidades.Cliente;
import com.api.unipar.repository.ClienteRepository;
import com.fasterxml.jackson.databind.util.BeanUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    private final ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public List<Cliente> listarTodosCLientes() {
        return clienteRepository.findAll();
    }

    public Cliente salvarCliente(Cliente cliente){
        return clienteRepository.save(cliente);
    }

    public Cliente buscarClientePorID(Long id){
        return clienteRepository.findById(id).orElseThrow(()->new RuntimeException("Cliente de id" + id + "não emcontrado"));
    }
    public void deletarClientePorId(Long id){
        clienteRepository.deleteById(id);
    }

    public Cliente updateCliente(Long id, Cliente cliente){
        Cliente clienteSalvo = buscarClientePorID(id);

        BeanUtils.copyProperties(cliente, clienteSalvo,"id");
        return clienteRepository.save(clienteSalvo);

    }

}
