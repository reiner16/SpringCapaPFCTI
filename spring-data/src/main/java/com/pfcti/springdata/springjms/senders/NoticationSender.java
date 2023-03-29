package com.pfcti.springdata.springjms.senders;


import com.pfcti.springdata.springjms.dto.NoticationDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class NoticationSender {

    @Autowired
    private JmsTemplate jmsTemplate;

    public void sendSms(NoticationDto noticationDto) {
        log.info("Enviando sms a la cola {} con numero de telefono", noticationDto.getPhoneNumber());
        jmsTemplate.convertAndSend("smsReceiverJms", noticationDto);
    }

}
