package com.pfcti.springdata.dto;

import lombok.Data;

@Data
public class TarjetaDto {
    private int id;
    private String Numero;
    private String Tipo;
    private boolean estado;
}
