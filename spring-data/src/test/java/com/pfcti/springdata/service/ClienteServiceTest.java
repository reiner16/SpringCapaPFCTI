package com.pfcti.springdata.service;

import com.pfcti.springdata.dto.ClienteDto;
import com.pfcti.springdata.model.Cliente;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Slf4j

class ClienteServiceTest {

    @Autowired
    private ClienteService clienteService;

    @PersistenceContext
    private EntityManager   entityManager;
    @Test
    void insertaCliente() {


        List <Cliente> clienteList = entityManager.createQuery("select c from Cliente c").getResultList();
        //log.info("listar antes de insertar: {}", clienteList);
        System.out.println("listar antes de insertar:" +  clienteList);
        ClienteDto clienteDto = new ClienteDto();
        clienteDto.setApellidos("Rojas");
        clienteDto.setNombre("Reiner");
        clienteDto.setCedula("238688");
        clienteDto.setTelefono("8989898");

        clienteService.insertaCliente(clienteDto);

        System.out.println("listar cuantos tiene:" +  clienteList.size());

        clienteList = entityManager.createQuery("select c from Cliente c").getResultList();
        assertFalse(clienteList.isEmpty());
        System.out.println("listar cuantos tiene: " + clienteList.size());
        //assertEquals("1890000000", clienteList.get(5).getCedula());

    }

    @Test
    void obtenerCliente() {

        ClienteDto clienteDto =  clienteService.obtenerCliente(1);
        System.out.println("El Cliente es " + clienteDto.getNombre() + " " +  clienteDto.getApellidos());
        assertEquals(1, clienteDto.getId());
    }

    @Test
    void actualizarCliente() {

        ClienteDto clienteDtoBase = clienteService.obtenerCliente(1);
        System.out.println(clienteDtoBase);

        clienteDtoBase.setNombre(clienteDtoBase.getNombre() + "TEST");
        clienteDtoBase.setCedula(clienteDtoBase.getCedula() + "TEST");
        clienteDtoBase.setTelefono(clienteDtoBase.getTelefono() + "TEST");
        clienteDtoBase.setApellidos(clienteDtoBase.getApellidos() + "TEST");
        clienteService.actualizarCliente(clienteDtoBase);

        ClienteDto clienteDtoBaseUpdated = clienteService.obtenerCliente(1);

        System.out.println(clienteDtoBaseUpdated);
        assertEquals("ROBERTOTEST", clienteDtoBaseUpdated.getNombre());
        assertEquals("PEREZTEST", clienteDtoBaseUpdated.getApellidos());
    }

    @Test
    void eliminarCliente() {
        ClienteDto clienteDtoBase = clienteService.obtenerCliente(1);
        assertEquals(1, clienteDtoBase.getId());

        clienteService.eliminarCliente(1);

        try {
            clienteService.obtenerCliente(1);
            fail("No debe llegar aca");
        } catch (RuntimeException e) {
            System.out.println("CLIENTE NO EXISTE: " + e.getMessage());
        }
    }


    @Test
    void obtenerClientesPorCodigoISOPaisYCuentasActivas() {
        List<ClienteDto> clientesDto = clienteService.obtenerClientesPorCodigoISOPaisYCuentasActivas("CR");
        clientesDto.forEach(clienteDto -> {System.out.println("Cuentas Activas" + clienteDto);});
        assertEquals(1, clientesDto.size());
    }

    @Test
    void buscarClientesPorApellido() {
        List<Cliente> cliente =  clienteService.buscarClientesPorApellido("PEREZ");
        assertFalse(cliente.isEmpty());
        assertEquals("PEREZ", cliente.get(0).getApellidos());
    }

    @Test
    void buscarClientesPorApellidoNativo() {

    }

    @Test
    void buscarClientesDinamicamentePorCriterio() {

        ClienteDto clienteDto = new ClienteDto();
        clienteDto.setNombre("ROBERTO");
        List<ClienteDto> resultadoCriteriosConDatosDTO =
                    clienteService.buscarClientesDinamicamentePorCriterio(clienteDto);

        resultadoCriteriosConDatosDTO.forEach(clienteDtoResultado -> {System.out.println("ClienteDto es:"+ clienteDtoResultado);});

        assertEquals(1,resultadoCriteriosConDatosDTO.size());
    }

}