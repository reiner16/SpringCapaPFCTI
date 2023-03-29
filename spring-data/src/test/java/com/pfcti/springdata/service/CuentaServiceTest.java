package com.pfcti.springdata.service;

import com.pfcti.springdata.dto.CuentaDto;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Slf4j
class CuentaServiceTest {

    @Autowired
    private CuentaService cuentaService;

    @Test
    void insertaCuenta() {
        CuentaDto cuentaDto = new CuentaDto();
        cuentaDto.setEstado(Boolean.TRUE);
        cuentaDto.setNumero("89898");
        cuentaDto.setTipo("AHORRO");
        cuentaService.insertaCuenta(cuentaDto);
        //cuentaService.insertaCuenta(cuentaDto);
    }
}