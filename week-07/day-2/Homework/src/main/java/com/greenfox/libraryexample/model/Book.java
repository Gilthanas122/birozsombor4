package com.greenfox.libraryexample.model;

public class Book {
  private static int nextId = 0;

  private int id;
  private String title;
  private String author;
  private int releaseYear;

  public Book() {
    this.id = nextId++;
  }

  public Book(String title, String author, int releaseYear) {
    this.id = nextId++;
    this.title = title;
    this.author = author;
    this.releaseYear = releaseYear;
  }

  public int getId() {
    return id;
  }

  public String getTitle() {
    return title;
  }

  public String getAuthor() {
    return author;
  }

  public int getReleaseYear() {
    return releaseYear;
  }

  public static void setNextId(int nextId) {
    Book.nextId = nextId;
  }

  public void setId(int id) {
    this.id = id;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public void setAuthor(String author) {
    this.author = author;
  }

  public void setReleaseYear(int releaseYear) {
    this.releaseYear = releaseYear;
  }
}
