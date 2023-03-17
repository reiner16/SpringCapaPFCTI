package com.pfcti.springdata.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name= "Direccion")
@Setter
@Getter
public class Direccion {

    @Id
    private int id;
    private String direccion;
    private String nomenclatura;

    @ManyToOne
    @JoinColumn(name = "cliente_id", referencedColumnName = "id")
    private Cliente cliente;

}
