package com.greenfoxacademy.dependencyinjection.greenfoxclassapp;

import java.util.List;

public interface StudentService {
  public List<String> findAll();

  public void save(String student);

  public int count();

  public boolean checkIfIsItExist(String name);
}
