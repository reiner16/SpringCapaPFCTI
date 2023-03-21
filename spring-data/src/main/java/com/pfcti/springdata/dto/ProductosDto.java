package com.pfcti.springdata.dto;

import lombok.Data;

import java.util.List;

@Data
public class ProductosDto {

    private List<CuentaDto> cuentaDto;
    private List<TarjetaDto> tarjetaDtos;
    private List<InversionDto> inversionDtos;

}


