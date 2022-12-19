package io.github.LeandroAmaralC.rest;


import io.github.LeandroAmaralC.model.entity.Cliente;
import io.github.LeandroAmaralC.model.entity.Produto;
import io.github.LeandroAmaralC.model.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
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
        Boolean existeProduto = repository.findById(produto.getId()).isPresent() ? true : false;
        if (existeProduto) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Não é possivel cadastrar esse ID, pois ele ja esta cadastrado no banco de dados");
        }

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

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void atualizar( @PathVariable Integer id,@RequestBody Produto produtoAtualizado ) {
        repository
                .findById(id)
                .map( produto -> {
                    produto.setId(produtoAtualizado.getId());
                    produto.setDescricao(produtoAtualizado.getDescricao());
                    produto.setPreco(produtoAtualizado.getPreco());
                    produto.setQuantidade(produtoAtualizado.getQuantidade());
                    return repository.save(produto);
                }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Produto não encontradp"));
    }


}
