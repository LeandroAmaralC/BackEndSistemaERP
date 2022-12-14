package io.github.LeandroAmaralC.rest;


import io.github.LeandroAmaralC.model.entity.Produto;
import io.github.LeandroAmaralC.model.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/produto")


public class ProdutoController {


    private final ProdutoRepository repository;

    @Autowired
    public ProdutoController(ProdutoRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Produto salvar(@RequestBody Produto produto) {
        String nome;
        nome = "";
        return repository.save(produto);
    }


    @GetMapping("acharPorID/{id}")
    public Produto acharPorID(@PathVariable Integer id) {
        String nome;
        nome = "";
        return repository.findById(id).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "Peça não encontrada"));
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletar(@PathVariable Integer id) {
        repository
                .findById(id)
                .map(produto -> {
                    repository.delete(produto);
                    return Void.TYPE;
                })
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Produto não encontradp"));
    }

    @GetMapping("/obterTodos")
    public List<Produto> ObterTodos() {
        return repository.findAll();
    }


}
