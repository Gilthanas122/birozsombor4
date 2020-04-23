package com.greenfoxacademy.dependencyinjection.greenfoxclassapp.controller;

import com.greenfoxacademy.dependencyinjection.greenfoxclassapp.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AppController {

  StudentService studentService;

  @Autowired
  public AppController(StudentService studentService) {
    this.studentService = studentService;
  }

  @GetMapping("/gfa")
  public String getHomePage(Model model) {
    model.addAttribute("userCounter", studentService.count());
    return "home";
  }

  @GetMapping("/gfa/list")
  public String listAllStudents(Model model) {
    model.addAttribute("students", studentService.findAll());
    return "students";
  }

  @GetMapping("/gfa/add")
  public String getViewOfAddNewStudent() {
    return "addview";
  }

  @PostMapping("/gfa/save")
  public String getViewOfAddNewStudent(String nameOfTheNewStudent) {
    studentService.save(nameOfTheNewStudent);
    return "redirect:/gfa/list";
  }

  @GetMapping("/gfa/check")
  public String getViewOfCheckStudents() {
    return "check";
  }

  @PostMapping("/gfa/check")
  public String checkingStudent(String name, Model model) {
    model.addAttribute("exist", studentService.checkIfIsItExist(name));
    model.addAttribute("name", name);
    return "check";
  }

}
