package com.greenfoxacademy.connectionwithmysql;

import com.greenfoxacademy.connectionwithmysql.model.Assignee;
import com.greenfoxacademy.connectionwithmysql.model.Todo;
import com.greenfoxacademy.connectionwithmysql.repository.AssigneeRepository;
import com.greenfoxacademy.connectionwithmysql.repository.TodoRepository;
import java.util.TimeZone;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ConnectionWithMysqlApplication implements CommandLineRunner {

  private TodoRepository todoRepository;
  private AssigneeRepository assigneeRepository;

  @Autowired
  public ConnectionWithMysqlApplication(TodoRepository todoRepository, AssigneeRepository assigneeRepository) {
    this.todoRepository = todoRepository;
    this.assigneeRepository = assigneeRepository;
  }

  public static void main(String[] args) {
    SpringApplication.run(ConnectionWithMysqlApplication.class, args);
  }

  @Override
  public void run(String... args) throws Exception {
    todoRepository.save(new Todo("daily task", "buisness", "basic", false, false));
    todoRepository.save(new Todo("make the beds", "personal", "hardcore", true, true));
    todoRepository.save(new Todo("do the washing up", "buisness", "easy", true, false));
    todoRepository.save(new Todo("clean the bathroom and the kitchen", "personal", "basic", true,
        true));
    todoRepository.save(new Todo("wipe all the surfaces with a cloth", "personal", "basic", true,
        false));
    todoRepository.save(new Todo("remove the grease", "buisness", "hardcore", true, true));
    todoRepository.save(new Todo("tidy up", "personal", "hardcore", false, false));
    todoRepository.save(new Todo("throw away the rubbish", "personal", "basic", true, true));
    todoRepository.save(new Todo("broom", "personal", "buisness", true, false));
    todoRepository.save(new Todo("sweep the floor", "personal", "basic", true, true));
    todoRepository.save(new Todo("wash the floors", "personal", "hardcore", true, false));
    todoRepository.save(new Todo("mop", "personal", "easy", true, true));
    todoRepository.save(new Todo("vacuum the carpet", "buisness", "basic", false, false));
    todoRepository.save(new Todo("vacuum cleaner / hoover", "personal", "basic", true, true));
    todoRepository.save(new Todo("dust the furniture", "personal", "basic", true, false));
    assigneeRepository.save(new Assignee("John", "john@asd.com"));
    assigneeRepository.save(new Assignee("Jane", "jane@qwe.com"));
    assigneeRepository.save(new Assignee("Bill", "bill@zui.com"));
    assigneeRepository.save(new Assignee("Thomas", "thomas@lyx.com"));
    assigneeRepository.save(new Assignee("Jonathan", "jonathan@asd.com"));
  }

  @PostConstruct
  void init() {
    TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
  }
}
