package com.greenfoxacademy.connectionwithmysql.repository;

import com.greenfoxacademy.connectionwithmysql.model.Todo;
import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface TodoRepository extends CrudRepository<Todo, Long> {

  List<Todo> findAllByTitleContainingIgnoreCase(String title);

  List<Todo> findAllByContentContainingIgnoreCase(String content);

  List<Todo> findAllByDescriptionContainingIgnoreCase(String desciption);

  @Query("SELECT todo FROM Todo todo WHERE todo.dateOfCreation = :searchDate")
  List<Todo> getTodosByDateOfCreation(Date searchDate);

  @Query("SELECT todo FROM Todo todo WHERE todo.dateOfDue = :searchDate")
  List<Todo> getTodosByDateOfDue(Date searchDate);

  @Query("SELECT todo FROM Todo todo WHERE todo.assignee.name LIKE :name")
  List<Todo> findByNames(String name);
}
