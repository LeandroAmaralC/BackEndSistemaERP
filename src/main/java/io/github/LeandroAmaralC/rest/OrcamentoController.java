package io.github.LeandroAmaralC.rest;

import io.github.LeandroAmaralC.model.entity.Orcamento;
import io.github.LeandroAmaralC.model.repository.OrcamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/orcamento/")
public class OrcamentoController {


    private final OrcamentoRepository repository;

    @Autowired
    public OrcamentoController(OrcamentoRepository repository) {this.repository = repository;}

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Orcamento salvar(@RequestBody @Valid Orcamento orcamento) {

        return repository.save(orcamento);}



    @GetMapping("acharPorID/{id}")
    public Orcamento acharPorID( @PathVariable Integer id) {
        return repository.findById(id).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "Peça não encontrada"));
    }

    @DeleteMapping({"id"})
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletar(@PathVariable Integer id) {
        repository
                .findById(id)
                .map( orcamento -> {
                    repository.delete(orcamento);
                    return Void.TYPE;
                })
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Orcamento não encontradp"));
    }

    @GetMapping("/obterTodos")
    public List<Orcamento> ObterTodos(){
        return repository.findAll();
    }


}
