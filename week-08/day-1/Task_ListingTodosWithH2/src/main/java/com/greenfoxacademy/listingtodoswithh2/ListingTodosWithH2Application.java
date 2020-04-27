package com.greenfoxacademy.listingtodoswithh2;

import com.greenfoxacademy.listingtodoswithh2.model.Todo;
import com.greenfoxacademy.listingtodoswithh2.repository.TodoRepository;
import com.sun.xml.bind.v2.TODO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ListingTodosWithH2Application implements CommandLineRunner {

  private TodoRepository todoRepository;

  @Autowired
  public ListingTodosWithH2Application(TodoRepository todoRepository) {
    this.todoRepository = todoRepository;
  }

  public static void main(String[] args) {
    SpringApplication.run(ListingTodosWithH2Application.class, args);
  }

  @Override
  public void run(String... args) throws Exception {
    todoRepository.save(new Todo("I have to learn Object Relational Mapping"));
    todoRepository.save(new Todo("Learn some JAVA"));
    todoRepository.save(new Todo("Learn more SQL"));
  }
}
