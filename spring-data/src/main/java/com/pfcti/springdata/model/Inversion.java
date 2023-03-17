package com.pfcti.springdata.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name= "Inversion")
@Setter
@Getter
public class Inversion {
    @Id
    private int id;
    private String Numero;
    private String Tipo;

    @ManyToOne
    @JoinColumn(name = "cliente_id" , referencedColumnName = "id")
    private Cliente cliente;
}
