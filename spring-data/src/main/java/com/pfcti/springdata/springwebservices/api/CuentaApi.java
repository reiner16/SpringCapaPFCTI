package com.pfcti.springdata.springwebservices.api;


import com.pfcti.springdata.dto.ClienteDto;
import com.pfcti.springdata.dto.CuentaDto;
import com.pfcti.springdata.service.ClienteService;
import com.pfcti.springdata.service.CuentaService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/api/cuenta")
@Slf4j
public class CuentaApi {

    @Autowired
    private CuentaService cuentaService;

    //@PostMapping("/{Guardar}")
    @PostMapping("/guardar")
    public void GuardarCuentaCliente(@Valid @RequestBody CuentaDto cuentaDto) {
        log.info("Cuenta de Cuenta: {}", cuentaDto );
        cuentaService.insertaCuenta(cuentaDto);

    }

    @GetMapping("/{id}")
    public List<CuentaDto> BuscarCuentaCliente(@PathVariable int id) {
        log.info("Busqueda de cliente: {}", id );
        return  cuentaService.buscarCuentasPorCliente(id)  ;
    }

    @PostMapping(value = "/desactivar")
    public CuentaDto desactivarCuentaPorIdCuenta(@RequestBody CuentaDto cuentaDto){
        log.info("Desactivar Cuenta por:", cuentaDto);
        return cuentaService.desactivarCuentaPorId(cuentaDto);
    }






}
