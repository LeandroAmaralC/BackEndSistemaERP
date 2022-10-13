package io.github.LeandroAmaralC.rest;

import io.github.LeandroAmaralC.model.repository.ClienteRepository;
import io.github.LeandroAmaralC.model.entity.Cliente;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/cliente")
@CrossOrigin("*")

public class ClienteController {


private final ClienteRepository repository;

@Autowired
public ClienteController(ClienteRepository repository) {this.repository = repository;}



    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Cliente salvar(@RequestBody @Valid  Cliente cliente){
        String nome;
        nome = "asfasas";
        return repository.save(cliente);
    }

    @GetMapping("/obterTodos")
    public List<Cliente> ObterTodos(){
    String nome;
    nome ="";
    return repository.findAll();
    }



    @GetMapping("acharPorID/{id}")
    public Cliente acharPorID( @PathVariable Integer id ) {
    return repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não encontrado"));
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
