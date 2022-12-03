package io.github.LeandroAmaralC.rest;


import io.github.LeandroAmaralC.model.entity.Orcamento;
import io.github.LeandroAmaralC.model.entity.Produtos;
import io.github.LeandroAmaralC.model.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/produto/")
@CrossOrigin("*")

public class ProdutoController {


    private final ProdutoRepository repository;

    @Autowired
    public ProdutoController(ProdutoRepository repository) {this.repository = repository;}

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Produtos salvar(@RequestBody @Valid Produtos produtos) {return repository.save(produtos);}



    @GetMapping("acharPorID/{id}")
    public Produtos acharPorID( @PathVariable Integer id) {
        String nome;
        nome = "";
        return repository.findById(id).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "Peça não encontrada"));
    }

    @DeleteMapping({"id"})
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletar(@PathVariable Integer id) {
        repository
                .findById(id)
                .map( produtos -> {
                    repository.delete(produtos);
                    return Void.TYPE;
                })
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Produto não encontradp"));
    }

    @GetMapping("/obterTodos")
    public List<Produtos> ObterTodos(){
        return repository.findAll();
    }


}
