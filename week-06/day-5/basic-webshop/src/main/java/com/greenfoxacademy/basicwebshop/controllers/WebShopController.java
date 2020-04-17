package com.greenfoxacademy.basicwebshop.controllers;

import com.greenfoxacademy.basicwebshop.models.ShopItem;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class WebShopController {

  List<ShopItem> shopItemsList = Arrays.asList(
      new ShopItem("Running shoes", "Nike running shoes for every day sport", 1000, 5),
      new ShopItem("Printer", "Some HP printer that will print pages", 3000, 2),
      new ShopItem("Coca cola", "0.5l standard coke", 25, 0),
      new ShopItem("Wokin", "Chicken with fried rice and WOKIN sauce", 119, 100),
      new ShopItem("T-shirt", "Blue with a corgi", 300, 1)
  );

  @ResponseBody
  @RequestMapping(value = "/webshop", method = RequestMethod.GET)
  public String greetTheWorld() {
    return "Hello World";
  }

  @RequestMapping(value = "", method = RequestMethod.GET)
  public String redirectToHomePage(Model model) {
    model.addAttribute("items", shopItemsList);
    return "index";
  }

  @RequestMapping(value = "/only-available", method = RequestMethod.GET)
  public String getOnlyAvailableItems(Model model) {
    model.addAttribute("items", shopItemsList.stream()
        .filter(item -> item.getQuantity() > 0)
        .collect(Collectors.toList()));
    return "index";
  }

  @RequestMapping(value = "/cheapest-first", method = RequestMethod.GET)
  public String sortDescendingOrderByPrice(Model model) {
    model.addAttribute("items", shopItemsList.stream()
        .sorted((item1, item2) -> Float.compare(item1.getPrice(), item2.getPrice()))
        .collect(Collectors.toList()));
    return "index";
  }

  @RequestMapping(value = "/contains-nike", method = RequestMethod.GET)
  public String getItemsWhichAreNikes(Model model) {
    model.addAttribute("items", shopItemsList.stream()
        .filter(item -> item.getName().toLowerCase().contains("nike") || item.getDescription().toLowerCase().contains("nike"))
        .collect(Collectors.toList()));
    return "index";
  }

  @RequestMapping(value = "/average-stock", method = RequestMethod.GET)
  public String getAverageStock(Model model) {
    model.addAttribute("averageOfStock", shopItemsList.stream()
        .mapToDouble(item -> item.getQuantity())
        .average()
        .getAsDouble());
    return "averageofstock";
  }

  @RequestMapping(value = "/most-expensive", method = RequestMethod.GET)
  public String getMostExpensive(Model model) {
    model.addAttribute("items", shopItemsList.stream()
        .sorted(Comparator.comparingDouble(ShopItem::getPrice).reversed())
        .limit(1)
        .collect(Collectors.toList()));
    return "index";
  }

  @RequestMapping(path = "/search", consumes = "",method = RequestMethod.POST)
  public String searchByNames(Model model, ShopItem shopItem) {
    model.addAttribute("averageOfStock", shopItemsList.stream()
        .filter(item -> item.getName().toLowerCase().contains(name.toLowerCase()) || item.getDescription().toLowerCase().contains(name.toLowerCase()))
        .collect(Collectors.toList()));
    return "index";
  }
}
