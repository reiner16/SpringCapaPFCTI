package com.pfcti.springdata.springbeans.business.impl;

import com.pfcti.springdata.dto.CuentaDto;
import com.pfcti.springdata.springbeans.business.BuscadorCuentas;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("servicioCuentasExterno")
public class BuscardorCuentasSistemaExterno implements BuscadorCuentas {

    @Override
    public List<CuentaDto> buscarCuentasPorCliente(int idCliente) {
        CuentaDto cuentaDto = new CuentaDto();
        cuentaDto.setCliente_id (1);
        cuentaDto.setId(1);
        cuentaDto.setEstado(true);
        cuentaDto.setNumero("123123213231212");
        cuentaDto.setTipo("VISA");
        return List.of(cuentaDto);
    }
}
