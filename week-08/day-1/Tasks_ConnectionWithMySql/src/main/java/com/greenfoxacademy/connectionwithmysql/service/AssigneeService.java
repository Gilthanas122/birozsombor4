package com.greenfoxacademy.connectionwithmysql.service;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.greenfoxacademy.connectionwithmysql.model.Assignee;
import com.greenfoxacademy.connectionwithmysql.model.Todo;
import com.greenfoxacademy.connectionwithmysql.repository.AssigneeRepository;
import com.greenfoxacademy.connectionwithmysql.repository.TodoRepository;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AssigneeService {
  private AssigneeRepository assigneeRepository;

  @Autowired
  public AssigneeService(AssigneeRepository assigneeRepository) {
    this.assigneeRepository = assigneeRepository;
  }

  public Iterable<Assignee> getAssignesFromDatabase() {
    return assigneeRepository.findAll();
  }

  public void addNewAssignee(Assignee assignee) {
    assigneeRepository.save(assignee);
  }

  public void deleteAnAssigneById(Long id) {
    Optional<Assignee> selectedAssignee = assigneeRepository.findById(id);
    if (selectedAssignee.isPresent()) {
      assigneeRepository.delete(selectedAssignee.get());
    }
  }

  public Assignee getAnAssigneeById(Long id) {
    Optional<Assignee> selectedAssignee = assigneeRepository.findById(id);
    if (selectedAssignee.isPresent()) {
      return selectedAssignee.get();
    }
    return null;
  }

  public void updateAnAssigneeInDatabase(Assignee assignee) {
    assigneeRepository.save(assignee);
  }
}
