package com.greenfoxacademy.optionaltasksdi.switchingmessageservices.service;

import org.springframework.stereotype.Service;

@Service
public class EmailService implements MessageService{
  @Override
  public void sendMessage(String message, String emailAddress) {
    System.out.println("Email sent to " + emailAddress + "with Message=" + message);
  }
}
// `Email Sent to office@greenfox.com with Message=Hi Barba! How are you?`</br>
