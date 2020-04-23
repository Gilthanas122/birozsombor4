package com.greenfoxacademy.optionalswitchingmessageservices.switchingmessageservices.configuration;

import com.greenfoxacademy.optionalswitchingmessageservices.switchingmessageservices.service.MessageService;
import org.apache.catalina.core.ApplicationContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class MessageProceeder {
  public void processMessage(String message, String emailAddress) {
    AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MessageConfiguration.class);
    MessageService messageService = (MessageService) context.getBean("emails");
    messageService.sendMessage(message, emailAddress);
  }
}
