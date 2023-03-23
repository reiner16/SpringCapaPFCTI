package com.pfcti.springdata.service;

import com.pfcti.springdata.criteria.CuentaSpecification;
import com.pfcti.springdata.dto.ClienteDto;
import com.pfcti.springdata.dto.CuentaDto;
import com.pfcti.springdata.model.Cliente;
import com.pfcti.springdata.model.Cuenta;
import com.pfcti.springdata.repository.ClienteRepository;
import com.pfcti.springdata.repository.CuentaRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.stream.Collectors;
import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class CuentaService {
    private CuentaRepository cuentaRepository;
    private CuentaSpecification cuentaSpecification;
    private ClienteRepository clienteRepository;

    @Autowired
    private ClienteService clienteService;

    private CuentaDto fromCuentaToDto(Cuenta cuenta){
        CuentaDto cuentaDto = new CuentaDto();
        BeanUtils.copyProperties(cuenta, cuentaDto);
        return cuentaDto;
    }

    public List<CuentaDto> buscarCuentasDinamicamentePorCriterio(CuentaDto cuentaDtoFilter){

        return cuentaRepository.findAll(cuentaSpecification.buildFilter(cuentaDtoFilter))
                .stream().map(this::fromCuentaToDto).collect(Collectors.toList());
    }

    public void insertaCuenta(CuentaDto cuentaDto) {
        Cuenta cuenta = new Cuenta();

        ClienteDto clienteDto =  clienteService.obtenerCliente(1);
        Cliente cliente = clienteRepository.findClienteById(1);

        cuenta.setCliente(cliente);

        cuenta.setTipo(cuentaDto.getTipo());
        cuenta.setNumero(cuentaDto.getNumero());
        cuenta.setEstado(cuentaDto.getEstado());

        cuentaRepository.save(cuenta);

    }


}
