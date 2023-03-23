package com.pfcti.springdata.springbeans.business;

import com.pfcti.springdata.dto.ClienteDto;
import com.pfcti.springdata.springbeans.dto.ClienteQueryDto;
import com.pfcti.springdata.springbeans.dto.ClienteQueryType;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.junit.jupiter.api.Assertions;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BuscadorClientesTest {

    @Autowired
    private  BuscadorClientes baseDeDatos;

    @Autowired
    @Qualifier("sistemaExterno")
    private  BuscadorClientes buscadorClientes;

    @Test
    void obtenerListaClientes() {
        ClienteQueryDto clienteQueryDto = new ClienteQueryDto();
        clienteQueryDto.setTextoBusqueda("1111");
        clienteQueryDto.setTipoBusqueda(ClienteQueryType.CEDULA);
        List<ClienteDto> resultadoClientesDtos = baseDeDatos.obtenerListaClientes(clienteQueryDto);
        resultadoClientesDtos.forEach(ClienteDto ->
                {
                    System.out.println("Resultado de la busqueda"  + ClienteDto.getNombre() + ClienteDto.getApellidos() );
                }
                );

    }


    @Test
    void obtenerListaClientesDeSistemaExterno(){
        ClienteQueryDto clienteQueryDto = new ClienteQueryDto();
        clienteQueryDto.setTextoBusqueda("1890000000");
        clienteQueryDto.setTipoBusqueda(ClienteQueryType.CEDULA);
        List<ClienteDto> resultadoClienteDtos = buscadorClientes.obtenerListaClientes(clienteQueryDto);
        resultadoClienteDtos.forEach(clienteDto ->
                {
                    System.out.println("Resultado de la busqueda" + clienteDto.getNombre() + clienteDto.getApellidos());
                }
        );
        Assertions.assertEquals(1, resultadoClienteDtos.size());
    }



}