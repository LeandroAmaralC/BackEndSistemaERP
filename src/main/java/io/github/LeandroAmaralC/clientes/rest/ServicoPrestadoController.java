package io.github.LeandroAmaralC.clientes.rest;

import io.github.LeandroAmaralC.clientes.model.enity.Cliente;
import io.github.LeandroAmaralC.clientes.model.enity.ServicoPrestado;
import io.github.LeandroAmaralC.clientes.model.repository.ClienteRepository;
import io.github.LeandroAmaralC.clientes.model.repository.ServicoPrestadoRepository;
import io.github.LeandroAmaralC.clientes.rest.dto.ServicoPrestadoDTO;
import io.github.LeandroAmaralC.clientes.util.BigDecimalConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

@RestController
@RequestMapping("/api/servicos-prestados")
@RequiredArgsConstructor
public class ServicoPrestadoController {

    private final ClienteRepository clienteRepository;
    private final ServicoPrestadoRepository repository;
    private final BigDecimalConverter bigDecimalConverter;



    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ServicoPrestado salvar(@RequestBody ServicoPrestadoDTO dto ) {
       LocalDate data = LocalDate.parse(dto.getData(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        Integer idCliente = dto.getIdCliente();

        Cliente cliente =
                clienteRepository
                        .findById(idCliente).orElseThrow(() ->
                                new ResponseStatusException(HttpStatus.BAD_REQUEST, "Cliente inexistente."));

        ServicoPrestado servicoPrestado = new ServicoPrestado();
        servicoPrestado.setDescricao(dto.getDescricao());
        servicoPrestado.setData( data );
        servicoPrestado.setCliente(cliente);
        servicoPrestado.setValor( bigDecimalConverter.converter(dto.getPreco()) );

        return repository.save(servicoPrestado);
    }
}
