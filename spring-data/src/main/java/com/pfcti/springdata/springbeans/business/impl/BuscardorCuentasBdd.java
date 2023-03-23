package com.pfcti.springdata.springbeans.business.impl;


import com.pfcti.springdata.dto.CuentaDto;
import com.pfcti.springdata.service.CuentaService;
import com.pfcti.springdata.springbeans.business.BuscadorCuentas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("servicioCuentasBdd")
public class BuscardorCuentasBdd implements BuscadorCuentas {

    @Autowired
    private CuentaService cuentaService;

    @Override
    public List<CuentaDto> buscarCuentasPorCliente(int idCliente) {
        return cuentaService.buscarCuentasPorCliente(idCliente);
    }
}