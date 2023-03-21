package com.pfcti.springdata.service;

import com.pfcti.springdata.dto.ClienteDto;
import com.pfcti.springdata.dto.InversionDto;
import com.pfcti.springdata.dto.TarjetaDto;
import com.pfcti.springdata.model.Cliente;
import com.pfcti.springdata.model.Inversion;
import com.pfcti.springdata.model.Tarjeta;
import com.pfcti.springdata.repository.InversionRepository;
import com.pfcti.springdata.repository.TarjetaRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class TarjetaService {

    TarjetaRepository tarjetaRepository;


    private TarjetaDto fromTarjetaToDto(Tarjeta tarjeta){
        TarjetaDto tarjetaDto = new TarjetaDto();
        BeanUtils.copyProperties(tarjeta, tarjetaDto);
        return tarjetaDto;
    }

    public List<Tarjeta> obtenerTarjetasPorIdCliente(int id){
        List<Tarjeta> resultado = tarjetaRepository.findByCliente_Id(id);
        return resultado;
    }


    public Tarjeta  actualizarEstadoTarjeta(int id, Boolean estado){

        Tarjeta tarjeta = tarjetaRepository.findById(id)
                .orElseThrow(() -> {throw new RuntimeException("tarjetas de Cliente No Existe");});
        tarjeta.setEstado(estado);
        return tarjeta;



    }
}
