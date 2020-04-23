package com.greenfoxacademy.optionaltasksdi.switchingmessageservices.configuration;

import com.greenfoxacademy.optionaltasksdi.switchingmessageservices.service.EmailService;
import com.greenfoxacademy.optionaltasksdi.switchingmessageservices.service.MessageService;
import com.greenfoxacademy.optionaltasksdi.switchingmessageservices.service.TwitterService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MessageConfiguration {

  @Bean
  public MessageService emailService(){
    return new EmailService();
  }

  public MessageService twitterService(){
    return new TwitterService();
  }
}
