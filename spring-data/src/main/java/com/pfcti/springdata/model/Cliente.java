package com.pfcti.springdata.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name= "cliente")
@Setter
@Getter
public class Cliente {
    @Id
    @GeneratedValue(strategy =
    GenerationType.IDENTITY)
    private int id;
    @Column(name="nombre")
    private String nombre;
    @Column(length =30)
    private String apellidos;
    @Column(columnDefinition  = "varchar(15)")
    private String cedula;
    private String telefono;
    private String paisNacimiento;

    @OneToMany(mappedBy = "cliente")
    private List<Direccion> direcciones;

    @OneToMany(mappedBy = "cliente")
    private List<Cuenta> cuentas;

    @OneToMany(mappedBy = "cliente")
    private List<Tarjeta> tarjetas;
}
