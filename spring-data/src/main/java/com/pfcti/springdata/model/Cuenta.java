package com.pfcti.springdata.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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
    @NotNull(message = "Numero cannot be null")
    @NotBlank (message = "Numero no puede ser blanco y debe llevar al menos un caracter")
    private String numero;

    private String tipo;
    @AssertTrue(message = "El estado debe ser activo")
    private Boolean estado; //activo-inactivo

    @ManyToOne
    @JoinColumn(name = "cliente_id", referencedColumnName = "id")
    private Cliente cliente;
}
