package com.pfcti.springdata.springjms.receivers;


import com.pfcti.springdata.springjms.dto.NoticationDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class NotificationProcessor {

    @JmsListener(destination = "smsReceiverJms")// va a representar el nombre de la cola donde se está escuchando
    public void processMessage(NoticationDto noticationDto){
        // Logica de envio de SMS
        log.info("sms info: {}", noticationDto);
    }
}
