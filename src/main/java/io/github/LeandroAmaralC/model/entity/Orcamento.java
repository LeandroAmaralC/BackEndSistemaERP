package io.github.LeandroAmaralC.model.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "orcamento")

public class Orcamento {

    @Id
    @Column(name = "id_orcamento", nullable = false, length = 100)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER,  cascade=CascadeType.ALL)
    @JoinColumn(name="id_cliente")
    private Cliente cliente;




}
