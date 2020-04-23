package com.greenfoxacademy.optionalswitchingmessageservices.switchingmessageservices.service;

import org.springframework.stereotype.Service;

@Service
public class TwitterService implements MessageService {
  @Override
  public void sendMessage(String message, String emailAddress) {
    System.out.println("Twitter message sent to " + emailAddress + "with Message=" + message);
  }
}
