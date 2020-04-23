package com.greenfoxacademy.dependencyinjection.greenfoxclassapp;

// # Greenfox Class App

// Create a controller with a few endpoints where Green Fox can manage their students.

// ## First steps
// - Have a main page at `/gfa`
// - This should contain links to all available pages
//     - List all students at first
// - List all students at `/gfa/list`
//     - should display an unordered list with all the students


// Use this `StudentService` as a dependency for your controller.

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {
  private List<String> names;

  public StudentServiceImpl() {
    names = new ArrayList<>();
    names.add("Sanyi");
    names.add("Lilla");
    names.add("John");
  }

  public List<String> findAll() {
    return names;
  }

  public void save(String student) {
    names.add(student);
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

// ## Adding new students
// - Extend the links with:
//     - Add new Student
// - Add new student at new `/gfa/add` endpoint
//     - should contain a form with an input for the new student's name
//     - send the form to the `POST /gfa/save` endpoint
//         - where you can use the service's `save()` method to save it

// ## Add student count to main page
// - Before the links have a header containing the current user count
// - Extend the service with a `count()` method

// ## Add a student checker page at `/gfa/check`
// - With a form for a `name`
// - Submitting a name the app can display if the student is already in the list
// - Add a link to the main page

// ## 💪 Optional (if you're on fire)
// - Create an interface containing the same method definitions as the service
// - Make the service class implement it (the methods already done, so just add it)
// - Create another implementation of the service where you store the names in `names.txt` instead of a list
// - Use the file saving service for the application
