package com.greenfoxacademy.connectionwithmysql.controller;

import com.greenfoxacademy.connectionwithmysql.model.Todo;
import com.greenfoxacademy.connectionwithmysql.repository.TodoRepository;
import com.greenfoxacademy.connectionwithmysql.service.TodoService;
import javax.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TodoController {

  private TodoService todoService;
  private TodoRepository todoRepository;

  @Autowired
  public TodoController(TodoRepository todoRepository, TodoService todoService) {
    this.todoRepository = todoRepository;
    this.todoService = todoService;
  }

  @GetMapping(value = {"/", "/list"})
  public String list(Model model, @RequestParam(required = false) Boolean isActive) {
    if (isActive == null) {
      model.addAttribute("todos", todoService.getTodosFromDatabase());
    } else {
      model.addAttribute("todos", todoService.getTodosByIsActive(isActive));
    }
    return "todolist";
  }

  @GetMapping(value = "/add")
  public String getAddNewTodoView(Model model) {
    model.addAttribute("newTodo", new Todo());
    return "add";
  }

  @PostMapping(value = "/add")
  public String addNewTodo(@ModelAttribute Todo todo) {
    todoService.addNewTodo(todo);
    return "redirect:/list";
  }

  @GetMapping(value = "/{id}/delete")
  public String deleteTodo(@PathVariable Long id) {
    todoService.deleteATodoById(id);
    return "redirect:/list";
  }

  @GetMapping(value = "/{id}/edit")
  public String getEditViewById(@PathVariable Long id, Model model) {
    model.addAttribute("selectedTodo", todoService.getATodoById(id));
    return "edit";
  }

  @PostMapping(value = "/edit/{id}")
  public String editATodo(@PathVariable Long id, @ModelAttribute Todo editedTodo) {
    todoService.updateATodoInDatabase(editedTodo);
    return "redirect:/list";
  }

  @GetMapping(value = "/{id}/inspect")
  public String getInspectViewById(@PathVariable Long id, Model model) {
    model.addAttribute("selectedTodo", todoService.getATodoById(id));
    return "inspect";
  }

}
