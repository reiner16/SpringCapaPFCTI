package com.pfcti.springdata.dto;

import jakarta.persistence.Id;

public class DireccionDto {

    @Id
    private int id;
    private String direccion;
    private String nomenclatura;
}
