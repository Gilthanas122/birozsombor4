package com.greenfoxacademy.connectionwithmysql.controller;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.greenfoxacademy.connectionwithmysql.model.Assignee;
import com.greenfoxacademy.connectionwithmysql.model.Todo;
import com.greenfoxacademy.connectionwithmysql.service.AssigneeService;
import com.greenfoxacademy.connectionwithmysql.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TodoController {

  private TodoService todoService;
  private AssigneeService assigneeService;


  @Autowired
  public TodoController(TodoService todoService, AssigneeService assigneeService) {
    this.todoService = todoService;
    this.assigneeService = assigneeService;
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

  @GetMapping(value = "/addTodo")
  public String getAddNewTodoView(Model model) {
    model.addAttribute("newTodo", new Todo());
    return "addtodo";
  }

  @PostMapping(value = "/addTodo")
  public String addNewTodo(@ModelAttribute Todo todo) {
    todoService.addNewTodo(todo);
    return "redirect:/list";
  }

  @GetMapping(value = "/{id}/deleteTodo")
  public String deleteTodo(@PathVariable Long id) {
    todoService.deleteATodoById(id);
    return "redirect:/list";
  }

  @GetMapping(value = "/{id}/editTodo")
  public String getEditViewById(@PathVariable Long id, Model model) {
    model.addAttribute("selectedTodo", todoService.getATodoById(id));
    model.addAttribute("assignees", assigneeService.getAssignesFromDatabase());
    return "edittodo";
  }

  @PostMapping(value = "/editTodo/{id}")
  public String editATodo(String assignee, @PathVariable Long id,
                          @ModelAttribute Todo editedTodo
  ) {
    todoService.updateATodoInDatabase(editedTodo);
    return "redirect:/list";
  }

  @GetMapping(value = "/{id}/inspectTodo")
  public String getInspectViewById(@PathVariable Long id, Model model) {
    model.addAttribute("selectedTodo", todoService.getATodoById(id));
    return "inspect";
  }

  @PostMapping(value = "/search")
  public String searchBySelectedFields(String searchText, String searchField) {
    return "redirect:/search?searchText=" + searchText + "&searchField=" + searchField;
  }

  @GetMapping(value = {"/search"})
  public String list(Model model, @RequestParam String searchText,
                     @RequestParam String searchField) {
    switch (searchField) {
      case "title":
        model.addAttribute("todos", todoService.getTodosByTitle(searchText));
        break;
      case "description":
        model.addAttribute("todos", todoService.getTodosByDescription(searchText));
        break;
      case "content":
        model.addAttribute("todos", todoService.getTodosByContent(searchText));
        break;
    }
    return "todolist";
  }

  @GetMapping(value = {"/listOfAssignees"})
  public String list(Model model) {
    model.addAttribute("assignees", assigneeService.getAssignesFromDatabase());
    return "assigneelist";
  }

  @GetMapping(value = "/addAssignee")
  public String getAddNewAssigneeView(Model model) {
    model.addAttribute("newAssignee", new Assignee());
    return "addassignee";
  }

  @PostMapping(value = "/addAssignee")
  public String addnewAssignee(@ModelAttribute Assignee assignee) {
    assigneeService.addNewAssignee(assignee);
    return "redirect:/listOfAssignees";
  }

  @GetMapping(value = "/{id}/deleteAssignee")
  public String deleteAssignee(@PathVariable Long id) {
    assigneeService.deleteAnAssigneById(id);
    return "redirect:/listOfAssignees";
  }

  @GetMapping(value = "/{id}/editAssignee")
  public String getEditAssigneeViewByIdTo(@PathVariable Long id, Model model) {
    model.addAttribute("selectedAssignee", assigneeService.getAnAssigneeById(id));
    return "editassignee";
  }

  @PostMapping(value = "/editAssignee/{id}")
  public String editAnAssignee(@PathVariable Long id, @ModelAttribute Assignee assignee) {
    assigneeService.updateAnAssigneeInDatabase(assignee);
    return "redirect:/listOfAssignees";
  }

}
