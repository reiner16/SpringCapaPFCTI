package com.pfcti.springdata.springjms.pubsub;

import com.pfcti.springdata.dto.CuentaDto;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.beanutils.PropertyUtilsBean;

import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.stereotype.Component;
import org.springframework.messaging.Message;

@Component
@Slf4j
@AllArgsConstructor
public class ProcesadorNotificacionClientes {

    @ServiceActivator(inputChannel = "pubSubNotification")
    public Message<String> consumirMensajeparaEnvioFormatoCliente(Message<CuentaDto> message) {
        CuentaDto cuentaDto = message.getPayload();
        log.info("consumirMensajeParaEnvioFormatoCliente");
        // Puede tener la logica que necesitemos
        // Envio SMS con formato a Cliente
        return MessageBuilder.withPayload("Mensaje recibido por ProcesadorNotificacionCliente")
                .build();
    }


}