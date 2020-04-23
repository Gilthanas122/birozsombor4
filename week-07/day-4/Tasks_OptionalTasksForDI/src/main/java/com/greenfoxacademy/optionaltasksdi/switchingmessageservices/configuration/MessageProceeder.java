package com.greenfoxacademy.optionaltasksdi.switchingmessageservices.configuration;

import com.greenfoxacademy.optionaltasksdi.switchingmessageservices.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MessageProceeder {
  private MessageService messageService;

  @Autowired
  public MessageProceeder(MessageService messageService) {
    this.messageService = messageService;
  }
  public void setMessageService(MessageService messageService) {
    this.messageService = messageService;
  }

  public void processMessage(String message, String emailAddress) {
    messageService.sendMessage(message,emailAddress);
  }
}
