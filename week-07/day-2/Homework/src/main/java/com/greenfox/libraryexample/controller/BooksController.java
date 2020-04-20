package com.greenfox.libraryexample.controller;

import com.greenfox.libraryexample.model.Book;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BooksController {

  private List<Book> books = new ArrayList<>();

  public BooksController() {
    books.add(new Book("Cat's Cradle", "Kurt Vonnegut", 1963));
    books.add(new Book("Do Androids Dream of Electric Sheep?", "Philip K. Dick", 1968));
  }

  @RequestMapping(value = "/books", method = RequestMethod.GET)
  public String listAllBooks(Model model, @RequestParam(required = false) String author) {
    if (author == null) {
      model.addAttribute("books", books);
    } else {
      model.addAttribute("books", books.stream()
          .filter(item -> item.getAuthor().equals(author))
          .collect(Collectors.toList()));
    }
    return "index";
  }

  @RequestMapping(value = "/books/{id}", method = RequestMethod.GET)
  public String getDetailsById(Model model, @PathVariable Integer id) {
    Book bookById = null;
    for (Book book : this.books) {
      if (book.getId() == id) {
        bookById = book;
      }
    }

    if (bookById != null) {
      model.addAttribute("book", bookById);
    } else {
      model.addAttribute("error", "No book found");
    }
    return "details";
  }

  @RequestMapping(value = "/books/add", method = RequestMethod.GET)
  public String getViewOfAdd(Model model) {
    model.addAttribute("book", new Book());
    return "addview";
  }

  @RequestMapping(value = "/books/add", method = RequestMethod.POST)
  public String getViewOfResult(@ModelAttribute("book") Book book) {
    books.add(book);
    return "redirect:/books";
  }
}
