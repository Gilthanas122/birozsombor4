package com.greenfoxacademy.connectionwithmysql.service;

import com.greenfoxacademy.connectionwithmysql.model.Todo;
import com.greenfoxacademy.connectionwithmysql.repository.TodoRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TodoService {

  private TodoRepository todoRepository;

  @Autowired
  public TodoService(TodoRepository todoRepository) {
    this.todoRepository = todoRepository;
  }

  public Iterable<Todo> getTodosFromDatabase() {
    return todoRepository.findAll();
  }

  public List<Todo> getTodosByIsActive(boolean isActive) {
    List<Todo> returnList = new ArrayList<>();
    todoRepository.findAll().forEach(returnList::add);
    if (isActive) {
      return returnList.stream()
          .filter(todo -> !todo.isDone())
          .collect(Collectors.toList());
    } else {
      return returnList.stream()
          .filter(todo -> todo.isDone())
          .collect(Collectors.toList());
    }
  }

  public void addNewTodo(Todo todo) {
    todoRepository.save(todo);
  }

  public void deleteATodoById(Long id) {
    Optional<Todo> selectedTodo = todoRepository.findById(id);
    if (selectedTodo.isPresent()) {
      todoRepository.delete(selectedTodo.get());
    }
  }
}
