package com.greenfoxacademy.dependencyinjection.greenfoxclassapp.service;

import java.util.List;

public interface StudentService {
  public List<String> findAll();

  public void save(String student);

  public int count();

  public boolean checkIfIsItExist(String name);
}
