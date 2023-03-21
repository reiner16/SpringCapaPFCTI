package com.pfcti.springdata.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name= "cuenta")
@Setter
@Getter
public class Cuenta {

    @Id
    @GeneratedValue(strategy =
            GenerationType.IDENTITY)
    private int id;
    private String numero;
    private String tipo;
    private Boolean estado; //activo-inactivo

    @ManyToOne
    @JoinColumn(name = "cliente_id", referencedColumnName = "id")
    private Cliente cliente;
}
