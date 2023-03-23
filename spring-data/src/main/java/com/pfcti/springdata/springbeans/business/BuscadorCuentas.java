package com.pfcti.springdata.springbeans.business;

import com.pfcti.springdata.dto.CuentaDto;

import java.util.List;

public interface BuscadorCuentas {

    List <CuentaDto> buscarCuentasPorCliente(int idCliente);
}
