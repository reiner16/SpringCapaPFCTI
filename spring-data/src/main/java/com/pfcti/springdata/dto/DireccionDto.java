package com.pfcti.springdata.dto;

import jakarta.persistence.Id;
import lombok.Data;

@Data
public class DireccionDto {

    @Id
    private int id;
    private String direccion;
    private String nomenclatura;
}
