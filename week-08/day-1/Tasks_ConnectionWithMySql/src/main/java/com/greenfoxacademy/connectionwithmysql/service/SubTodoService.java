package com.greenfoxacademy.connectionwithmysql.service;

import com.greenfoxacademy.connectionwithmysql.model.SubTodo;
import com.greenfoxacademy.connectionwithmysql.model.Todo;
import com.greenfoxacademy.connectionwithmysql.repository.SubTodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SubTodoService {

  private SubTodoRepository subTodoRepository;
  private TodoService todoService;

  @Autowired
  public SubTodoService(SubTodoRepository subTodoRepository, TodoService todoService) {
    this.subTodoRepository = subTodoRepository;
    this.todoService = todoService;
  }

  public void addNewSubTodo(SubTodo subTodo, Long todoId) {
    Todo todo = todoService.getATodoById(todoId);
    subTodo.setTodo(todo);
    subTodoRepository.save(subTodo);
  }

  public void deleteSubTodoById(Long id) {
    subTodoRepository.deleteById(id);
  }
}
