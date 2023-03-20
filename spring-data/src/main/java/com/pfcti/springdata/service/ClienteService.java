package com.pfcti.springdata.service;

import com.pfcti.springdata.dto.ClienteDto;
import com.pfcti.springdata.model.Cliente;
import com.pfcti.springdata.repository.ClienteRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ClienteService {
        ClienteRepository   clienteRepository;

        public void insertaCliente(ClienteDto clienteDto) {
                Cliente cliente = new Cliente();
                cliente.setApellidos(clienteDto.getApellidos());
                cliente.setNombre(clienteDto.getNombre());
                cliente.setCedula(clienteDto.getCedula());
                cliente.setTelefono(clienteDto.getTelefono());
                clienteRepository.save(cliente);

        }

        public ClienteDto obtenerCliente (int idCliente) {
                Cliente cliente = clienteRepository.findById(idCliente)
                        .orElseThrow(
                                () -> {throw new RuntimeException("Cliente no existe");});

                ClienteDto clienteDto = new ClienteDto();
                clienteDto.setId(cliente.getId());
                clienteDto.setApellidos(cliente.getApellidos());
                clienteDto.setNombre(cliente.getNombre());
                clienteDto.setCedula(cliente.getCedula());

                return clienteDto;
        }

        public void actualizarCliente(ClienteDto clienteDto){
                Cliente cliente = new Cliente();
                cliente.setId(clienteDto.getId());
                cliente.setNombre(clienteDto.getNombre());
                cliente.setApellidos(clienteDto.getApellidos ());
                cliente.setCedula(clienteDto.getCedula());
                cliente.setTelefono(clienteDto.getTelefono());
                clienteRepository.save(cliente);
        }

        public void eliminarCliente(Integer clienteId){
                clienteRepository.deleteById(clienteId);
        }

}
