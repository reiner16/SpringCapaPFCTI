package com.pfcti.springdata.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.apache.logging.log4j.message.Message;

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
    @NotNull(message = "Name cannot be null")
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