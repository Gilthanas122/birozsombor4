package com.greenfoxacademy.connectionwithmysql.service;

import com.greenfoxacademy.connectionwithmysql.model.Assignee;
import com.greenfoxacademy.connectionwithmysql.model.Todo;
import com.greenfoxacademy.connectionwithmysql.repository.TodoRepository;
import java.lang.reflect.Array;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TodoService {

  private TodoRepository todoRepository;
  private AssigneeService assigneeService;

  @Autowired
  public TodoService(TodoRepository todoRepository, AssigneeService assigneeService) {
    this.todoRepository = todoRepository;
    this.assigneeService = assigneeService;
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

  public Todo getATodoById(Long id) {
    Optional<Todo> selectedTodo = todoRepository.findById(id);
    if (selectedTodo.isPresent()) {
      return selectedTodo.get();
    }
    return null;
  }

  public void updateATodoInDatabase(Todo todo, Long selectedAssigneeId, String dateOfDue) {
    Assignee assignee = assigneeService.getAnAssigneeById(selectedAssigneeId);
    todo.setAssignee(assignee);
    todo.setDateOfCreation(new Date());
    todo.setDateOfDueWithStringParameter(dateOfDue);
    ArrayList<Todo> updatedTodos = new ArrayList<>();
    updatedTodos.add(todo);
    assignee.setTodos(updatedTodos);
    assigneeService.updateAnAssigneeInDatabase(assignee);
    todoRepository.save(todo);
  }

  public List<Todo> getTodosByTitle(String searchText) {
    return todoRepository.findAllByTitleContainingIgnoreCase(searchText);
  }

  public List<Todo> getTodosByDescription(String searchText) {
    return todoRepository.findAllByDescriptionContainingIgnoreCase(searchText);
  }

  public List<Todo> getTodosByContent(String searchText) {
    return todoRepository.findAllByContentContainingIgnoreCase(searchText);
  }

  public Date convertStringToDate(String date) {
    try {
      SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
      return format.parse(date);
    } catch (Exception e) {
      System.out.println("Failed date parsing");
      System.exit(-1);
    }
    return null;
  }

  public List<Todo> getTodosByDateOfCreation(Date searchDate) {
    return todoRepository.findAllByDateOfCreation(searchDate);
  }

  public List<Todo> getTodosByDateOfDue(Date searchDate) {
    return todoRepository.findAllByDateOfDue(searchDate);
  }

  public List<Todo> getTodosByAssigneeName(String name) {
    return todoRepository.findByNames(name);
  }
}
