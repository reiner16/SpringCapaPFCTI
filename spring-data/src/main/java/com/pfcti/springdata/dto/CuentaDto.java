package com.pfcti.springdata.dto;

import lombok.Data;

@Data
public class CuentaDto {
    private int id;
    private String numero;
    private String tipo;
    private Boolean estado;
    private int cliente_id;

}
