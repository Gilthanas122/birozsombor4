package com.greenfoxacademy.dependencyinjection.greenfoxclassapp;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@Primary
public class AnotherStudentServiceImpl implements StudentService {
  private List<String> names;

  public AnotherStudentServiceImpl() {
    names = initAllNamesFromFile();
  }

  public List<String> initAllNamesFromFile(){
    List<String> names = new ArrayList<>();
    try{
      names = Files.readAllLines(Paths.get("names.txt"));
    }
    catch (NoSuchFileException e){
      System.out.println("There is no such file");
      System.exit(-1);
    } catch (IOException e){
      System.out.println("Something went wrong with reading");
      System.exit(-1);
    }
    return names;
  }

  public List<String> findAll() {
    return names;
  }

  public void save(String student) {
    names.add(student);
    try {
      Files.write(Paths.get("names.txt"), names);
    } catch (IOException e) {
      System.out.println("Something went wrong with the writing!");
      System.exit(-1);
    }
  }

  public int count() {
    return names.size();
  }

  public boolean checkIfIsItExist(String name) {
    return names.stream()
        .map(names -> names.toLowerCase())
        .collect(Collectors.toList())
        .contains(name.toLowerCase());
  }
}
