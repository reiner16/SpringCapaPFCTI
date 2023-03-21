package com.pfcti.springdata.service;

import com.pfcti.springdata.dto.ClienteDto;
import com.pfcti.springdata.dto.TarjetaDto;
import com.pfcti.springdata.model.Tarjeta;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
@Slf4j


class TarjetaServiceTest {

    @Autowired
    private TarjetaService tarjetaService;



    @Test
    void actualizarEstadoTarjeta() {

        //inactivar con estado en false
        Tarjeta tarjeta = tarjetaService.actualizarEstadoTarjeta(1, false);
        assertEquals(false,tarjeta.getEstado());

    }
}