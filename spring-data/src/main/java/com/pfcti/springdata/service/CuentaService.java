package com.pfcti.springdata.service;

import com.pfcti.springdata.criteria.CuentaSpecification;
import com.pfcti.springdata.dto.ClienteDto;
import com.pfcti.springdata.dto.CuentaDto;
import com.pfcti.springdata.model.Cliente;
import com.pfcti.springdata.model.Cuenta;
import com.pfcti.springdata.repository.ClienteRepository;
import com.pfcti.springdata.repository.CuentaRepository;
import com.pfcti.springdata.springjms.dto.NoticationDto;
import com.pfcti.springdata.springjms.pubsub.publishers.NotificationPubSubSender;
import com.pfcti.springdata.springjms.senders.NoticationSender;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.List;


import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.Message;

@Service
@Transactional
@AllArgsConstructor
@Slf4j
public class CuentaService {
    private CuentaRepository cuentaRepository;
    private CuentaSpecification cuentaSpecification;
    private ClienteRepository clienteRepository;
    private NoticationSender noticationSender;

    private NotificationPubSubSender notificationPubSubSender;

    @Autowired
    private ClienteService  clienteService;

    // private ClienteService clienteService;

    private Cuenta fromDtoToCuenta(CuentaDto cuentaDto) {
        Cuenta cuenta = new Cuenta();
        BeanUtils.copyProperties(cuentaDto, cuenta);
        return cuenta;
    }

    private CuentaDto fromCuentaToDto(Cuenta cuenta){
        CuentaDto cuentaDto = new CuentaDto();
        BeanUtils.copyProperties(cuenta, cuentaDto);
        cuentaDto.setCliente_id(cuenta.getCliente().getId());
        return cuentaDto;
    }

    public List<CuentaDto> buscarCuentasDinamicamentePorCriterio(CuentaDto cuentaDtoFilter){

        return cuentaRepository.findAll(cuentaSpecification.buildFilter(cuentaDtoFilter))
                .stream().map(this::fromCuentaToDto).collect(Collectors.toList());
    }

    public void insertaCuenta(CuentaDto cuentaDto) {
        Cuenta cuenta = new Cuenta();

        Cliente cliente = clienteRepository.findClienteById(1);

        cuenta.setCliente(cliente);

        cuenta.setTipo(cuentaDto.getTipo());
        cuenta.setNumero(cuentaDto.getNumero());
        cuenta.setEstado(cuentaDto.getEstado());

        cuentaRepository.save(cuenta);
        this.enviarNotificacion(cuentaDto);
    }


    public void creacionDeCuenta(CuentaDto cuentaDto){
        Cuenta cuenta = new Cuenta();
        cuenta = fromDtoToCuenta(cuentaDto);
        cuentaRepository.save(cuenta);
        log.info("Cuenta: {} ", cuenta);
        //Notificacion
        //noticationSender.sendSms();
        this.enviarNotificacion(cuentaDto);
    }

    private void enviarNotificacion(CuentaDto cuentaDto){
        NoticationDto noticationDto = new NoticationDto();
        ClienteDto clienteDto = clienteService.obtenerCliente(cuentaDto.getCliente_id ());
        noticationDto.setPhoneNumber(clienteDto.getTelefono());
        noticationDto.setMailBody("Estimado " + clienteDto.getNombre() + "tu cuenta fue creada");
        noticationSender.sendSms(noticationDto);

        Message<CuentaDto> message = MessageBuilder.withPayload(cuentaDto).build();
        notificationPubSubSender.sendNotification(message);

    }


    public List<CuentaDto> buscarCuentasPorCliente(int idCliente) {
        List<CuentaDto> cuentasPorCliente = new ArrayList<>();
        cuentaRepository.findByCliente_IdAndEstadoIsTrue(idCliente)
                .stream()
                .map(cuenta -> {
                    cuentasPorCliente.add(fromCuentaToDto(cuenta));
                    log.info("Cuenta de Cliente :{}", cuenta);
                    return cuenta;}
                ).collect(Collectors.toList());
        return cuentasPorCliente;
    }


    public CuentaDto desactivarCuentaPorId(CuentaDto cuentaDto){
        Cuenta cuenta = cuentaRepository.findById(cuentaDto.getId()).orElseThrow(() -> {throw new RuntimeException("cuenta de Cliente No Existe");});
        cuenta.setEstado(false);
        cuentaRepository.save(cuenta);
        return fromCuentaToDto(cuenta);
    }



}
