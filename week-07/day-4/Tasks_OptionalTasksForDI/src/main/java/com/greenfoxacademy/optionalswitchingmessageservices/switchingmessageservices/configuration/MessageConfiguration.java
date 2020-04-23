package com.greenfoxacademy.optionalswitchingmessageservices.switchingmessageservices.configuration;

import com.greenfoxacademy.optionalswitchingmessageservices.switchingmessageservices.service.EmailService;
import com.greenfoxacademy.optionalswitchingmessageservices.switchingmessageservices.service.MessageService;
import com.greenfoxacademy.optionalswitchingmessageservices.switchingmessageservices.service.TwitterService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MessageConfiguration {


  public MessageService emailService() {
    return new EmailService();
  }

  @Bean(name = "emails")
  public MessageService twitterService() {
    return new TwitterService();
  }
}
