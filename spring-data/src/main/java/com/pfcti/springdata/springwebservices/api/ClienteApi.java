package com.pfcti.springdata.springwebservices.api;


import com.pfcti.springdata.dto.ClienteDto;
import com.pfcti.springdata.model.Cliente;
import com.pfcti.springdata.service.ClienteService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/v1/api/cliente")
@Slf4j
public class ClienteApi {
    @Autowired
    private ClienteService clienteService;

    @GetMapping("/{id}")
    public ClienteDto BuscarCliente(@PathVariable int id) {
        log.info("Busqueda de cliente: {}", id );
        return  clienteService.obtenerCliente(id);
    }

    @GetMapping(value = "/xml/{id}", produces = MediaType.APPLICATION_XML_VALUE)
    public ClienteDto BuscarClienteXml(@PathVariable int id) {
        log.info("Busqueda de cliente: {}", id );
        return  clienteService.obtenerCliente(id);
    }


    @GetMapping(value = "/xml/json/{id}", produces = {MediaType.APPLICATION_XML_VALUE ,
            MediaType.APPLICATION_JSON_VALUE})
    public ClienteDto BuscarClienteXmlJson(@PathVariable int id) {
        log.info("Busqueda de cliente: {}", id );
        return  clienteService.obtenerCliente(id);
    }


    @GetMapping(value = "/parameter", produces = {MediaType.APPLICATION_XML_VALUE ,
            MediaType.APPLICATION_JSON_VALUE})
    public ClienteDto BuscarClienteParametro(@RequestParam int id) {
        log.info("Busqueda de cliente: {}", id );
        return  clienteService.obtenerCliente(id);
    }

    @PostMapping
    public void GuardarCliente(@Valid @RequestBody ClienteDto clienteDto) {
        log.info("Cliente de cliente: {}", clienteDto );
        clienteService.insertaCliente(clienteDto);
    }

    @GetMapping(value = "/all")
    public List<ClienteDto> BuscartodosLosClientes () {
        log.info("Obtener todos los clientes:" );
        return clienteService.listarTodosLosClientes();
    }

    @PutMapping
    public void ActualizarCliente (@RequestBody ClienteDto clienteDto) {
        log.info("Actualizar Cliente: {} " , clienteDto );
        clienteService.actualizarCliente(clienteDto);
    }

    @DeleteMapping(value ="/{id}")
    public void EliminarCliente (@PathVariable int id) {
        log.info("Eliminar cliente id: " , id);
        clienteService.eliminarCliente(id);
    }
}
