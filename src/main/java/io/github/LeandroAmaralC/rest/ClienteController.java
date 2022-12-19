package io.github.LeandroAmaralC.rest;


import io.github.LeandroAmaralC.model.entity.Cliente;
import io.github.LeandroAmaralC.model.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/cliente")

public class ClienteController {
private final ClienteRepository repository;

@Autowired
public ClienteController(ClienteRepository repository) {this.repository = repository;}

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Cliente salvar(@RequestBody Cliente cliente){
        return repository.save(cliente);
    }

    @GetMapping("/obterTodos")
    public List<Cliente> ObterTodos(){
    return repository.findAll();
    }



    @GetMapping("acharPorID/{id}")
    public Cliente acharPorID( @PathVariable Integer id ) {
        String nome;
    return repository.findById(id).orElseThrow(() ->
            new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não encontrado"));

    }

    @GetMapping("acharPorCPF/{cpf}")
    public Cliente acharPorCPF( @PathVariable String cpf ) {
        String nome;
        nome ="";
        return repository.findByCpf(cpf).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não encontrado"));
    }


    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletar(@PathVariable Integer id){
        repository
                .findById(id)
                .map( cliente -> {
                    repository.delete(cliente);
                    return Void.TYPE;
        })
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não encontrado"));
    }



}
