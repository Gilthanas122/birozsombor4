package com.greenfoxacademy.connectionwithmysql.repository;

import com.greenfoxacademy.connectionwithmysql.model.Todo;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface TodoRepository extends CrudRepository<Todo, Long> {

  List<Todo> findAllByTitleContainingIgnoreCase(String title);

  List<Todo> findAllByContentContainingIgnoreCase(String content);

  List<Todo> findAllByDescriptionContainingIgnoreCase(String desciption);
}
