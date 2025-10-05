package com.api.unipar.controller;

import com.api.unipar.entidades.Cliente;
import com.api.unipar.service.ClienteService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/clientes")
public class ClientesController {

    private final ClienteService clienteService;

    public ClientesController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @GetMapping("/listar")
    public List<Cliente> listarTodosClientes() {
        return clienteService.listarTodosCLientes();
    }

    @PostMapping ("/salvar")
    public Cliente salvarCliente(@RequestBody Cliente cliente){
        return clienteService.salvarCliente((cliente));
    }

    @GetMapping("/buscar-cliente/{id}")
    public Cliente buscarClientePorId( @PathVariable Long id){
        return clienteService.buscarClientePorID(id);
    }

    @DeleteMapping("/deletar-cliente/{id}")
    public void deletarClientePorid(@PathVariable Long id){
        clienteService.deletarClientePorId(id);
    }

    @PutMapping("/atualizar-cliente/{id}")
    public Cliente atualizarClienteId(@PathVariable Long id, @RequestBody Cliente cliente){
        return clienteService.updateCliente(id,cliente);
    }
}
