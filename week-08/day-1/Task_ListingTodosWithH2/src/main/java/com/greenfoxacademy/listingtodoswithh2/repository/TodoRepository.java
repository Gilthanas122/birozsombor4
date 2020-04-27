package com.greenfoxacademy.listingtodoswithh2.repository;

import com.greenfoxacademy.listingtodoswithh2.model.Todo;
import org.springframework.data.repository.CrudRepository;

public interface TodoRepository extends CrudRepository<Todo, Long> {
}
