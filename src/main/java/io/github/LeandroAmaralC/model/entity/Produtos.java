package io.github.LeandroAmaralC.model.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "produto")

public class Produtos {

    @Id
    @Column(name = "cod_produto", nullable = false, length = 100)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "descricao", nullable = false, length = 150)
    @NotEmpty(message = "{campo.nome.e.obrigatorio}")
    private String descricao;

    @Column(name = "preco", nullable = false)
    private Integer preco;

    @Column(name = "quantidade", nullable = false)
    @NotEmpty(message = "{campo.quantidade.e.obrigatorio}")
    private Integer quantidade;

}
