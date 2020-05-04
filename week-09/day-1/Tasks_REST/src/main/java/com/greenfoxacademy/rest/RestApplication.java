package com.greenfoxacademy.rest;

import com.greenfoxacademy.rest.model.Log;
import com.greenfoxacademy.rest.repository.LogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RestApplication implements CommandLineRunner {

  public static void main(String[] args) {
    SpringApplication.run(RestApplication.class, args);
  }

  private LogRepository logRepository;

  @Autowired
  public RestApplication(LogRepository logRepository) {
    this.logRepository = logRepository;
  }

  @Override
  public void run(String... args) throws Exception {
    //logRepository.save(new Log());
  }
}
