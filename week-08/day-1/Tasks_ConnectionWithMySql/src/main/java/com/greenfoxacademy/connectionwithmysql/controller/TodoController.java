package com.greenfoxacademy.connectionwithmysql.controller;

import com.greenfoxacademy.connectionwithmysql.model.Assignee;
import com.greenfoxacademy.connectionwithmysql.model.Todo;
import com.greenfoxacademy.connectionwithmysql.service.AssigneeService;
import com.greenfoxacademy.connectionwithmysql.service.TodoService;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
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

  @PostMapping(value = "/editTodo")
  public String editATodo(Long selectedAssigneeId,
                          String selectedDateOfDue,
                          @ModelAttribute Todo editedTodo) {
    todoService.updateATodoInDatabase(editedTodo, selectedAssigneeId, selectedDateOfDue);
    return "redirect:/list";
  }

  @GetMapping(value = "/{id}/inspectTodo")
  public String getInspectViewById(@PathVariable Long id, Model model) {
    model.addAttribute("selectedTodo", todoService.getATodoById(id));
    return "inspecttodo";
  }

  @PostMapping(value = "/searchByTextFields")
  public String searchBySelectedFields(String searchText, String searchField) {
    return "redirect:/searchByTextFields?searchText=" + searchText + "&searchField=" + searchField;
  }

  @GetMapping(value = {"/searchByTextFields"})
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

  @PostMapping(value = "/searchByDate")
  public String searchBySelectedDate(String searchDate, String searchDateOption) {
    return "redirect:/searchByDate?searchDate=" + searchDate + "&searchDateOption=" + searchDateOption;
  }

  @GetMapping(value = {"/searchByDate"})
  public String getListOfTodosBySearchDate(Model model, @RequestParam String searchDate,
                                           @RequestParam String searchDateOption) {
    switch (searchDateOption) {
      case "dueDate":
        model.addAttribute("todos",
            todoService.getTodosByDateOfDue(todoService.convertStringToDate(searchDate)));
        break;
      case "creationDate":
        model.addAttribute("todos", todoService.getTodosByDateOfCreation(todoService.convertStringToDate(searchDate)));
        break;
    }
    return "todolist";
  }

  @PostMapping(value = "/searchByAssigneeName")
  public String searchByName(String searchName) {
    return "redirect:/searchByAssigneeName?name=" + searchName;
  }

  @GetMapping(value = {"/searchByAssigneeName"})
  public String getListOfTodosByName(Model model, @RequestParam String name) {
    model.addAttribute("todos",todoService.getTodosByAssigneeName(name));
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

  @GetMapping(value = "/{id}/inspectAssignee")
  public String getInspectAssigneeViewById(@PathVariable Long id, Model model) {
    model.addAttribute("selectedAssignee", assigneeService.getAnAssigneeById(id));
    return "inspectassignee";
  }

}
