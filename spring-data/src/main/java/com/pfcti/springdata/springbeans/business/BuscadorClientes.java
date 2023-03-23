package com.pfcti.springdata.springbeans.business;

import com.pfcti.springdata.dto.ClienteDto;
import com.pfcti.springdata.springbeans.dto.ClienteQueryDto;

import java.util.List;

public interface BuscadorClientes {

    List<ClienteDto> obtenerListaClientes(ClienteQueryDto clienteQueryDto);

}
