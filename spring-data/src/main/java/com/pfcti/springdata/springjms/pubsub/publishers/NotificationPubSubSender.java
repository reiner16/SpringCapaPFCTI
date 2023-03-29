package com.pfcti.springdata.springjms.pubsub.publishers;


import com.pfcti.springdata.dto.CuentaDto;
import org.springframework.integration.annotation.Gateway;
import org.springframework.integration.annotation.MessagingGateway;
import org.springframework.messaging.Message;

@MessagingGateway
public interface NotificationPubSubSender {
    @Gateway(requestChannel = "pubSubNotification")
    Message<String> sendNotification(Message<CuentaDto> message);
}

