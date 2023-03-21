package com.pfcti.springdata.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name= "tarjeta")
@Setter
@Getter
public class Tarjeta {

    @Id
    @GeneratedValue(strategy =
            GenerationType.IDENTITY)
    private int id;
    private String numero;
    private String tipo;
    private Boolean estado; //activo-inactivo

    @ManyToOne
    @JoinColumn(name = "cliente_id" , referencedColumnName = "id")
    private Cliente cliente;
}
