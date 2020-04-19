package com.greenfoxacademy.basicwebshop.controllers;

import com.greenfoxacademy.basicwebshop.models.ShopItem;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class WebShopController {

  List<ShopItem> shopItemsList;

  public WebShopController() {
    this.shopItemsList = Arrays.asList(
        new ShopItem("Running shoes", "Nike running shoes for every day sport", 1000, 5, "dress"),
        new ShopItem("Printer", "Some HP printer that will print pages", 3000, 2, "device"),
        new ShopItem("Coca cola", "0.5l standard coke", 25, 0, "food"),
        new ShopItem("Wokin", "Chicken with fried rice and WOKIN sauce", 119, 100, "food"),
        new ShopItem("T-shirt", "Blue with a corgi", 300, 1, "dress")
    );
  }

  @ResponseBody
  @RequestMapping(value = "/webshop", method = RequestMethod.GET)
  public String greetTheWorld() {
    return "Hello World";
  }

  @RequestMapping(value = "", method = RequestMethod.GET)
  public String redirectToHomePage(Model model) {
    model.addAttribute("items", shopItemsList);
    model.addAttribute("currency", new String("CZK"));
    return "index";
  }

  @RequestMapping(value = "/only-available", method = RequestMethod.GET)
  public String getOnlyAvailableItems(Model model) {
    model.addAttribute("items", shopItemsList.stream()
        .filter(item -> item.getQuantity() > 0)
        .collect(Collectors.toList()));
    model.addAttribute("currency", new String("CZK"));
    return "index";
  }

  @RequestMapping(value = "/cheapest-first", method = RequestMethod.GET)
  public String sortAscendingOrderByPrice(Model model) {
    model.addAttribute("items", shopItemsList.stream()
        .sorted((item1, item2) -> Float.compare(item1.getPrice(), item2.getPrice()))
        .collect(Collectors.toList()));
    model.addAttribute("currency", new String("CZK"));
    return "index";
  }

  @RequestMapping(value = "/contains-nike", method = RequestMethod.GET)
  public String getItemsWhichAreNikes(Model model) {
    model.addAttribute("items", shopItemsList.stream()
        .filter(item -> item.getName().toLowerCase().contains("nike") || item.getDescription().toLowerCase().contains("nike"))
        .collect(Collectors.toList()));
    model.addAttribute("currency", new String("CZK"));
    return "index";
  }

  @RequestMapping(value = "/average-stock", method = RequestMethod.GET)
  public String getAverageStock(Model model) {
    model.addAttribute("averageOfStock", shopItemsList.stream()
        .mapToDouble(item -> item.getQuantity())
        .average()
        .orElseGet(() -> 0));
    model.addAttribute("currency", new String("CZK"));
    return "averageofstock";
  }

  @RequestMapping(value = "/most-expensive", method = RequestMethod.GET)
  public String getMostExpensive(Model model) {
    model.addAttribute("items", shopItemsList.stream()
        .sorted(Comparator.comparingDouble(ShopItem::getPrice).reversed())
        .limit(1)
        .collect(Collectors.toList()));
    model.addAttribute("currency", new String("CZK"));
    return "index";
  }

  @RequestMapping(path = "/search", method = RequestMethod.POST)
  public String searchByNames(String searchInput,
                              Model model) {
    model.addAttribute("items", shopItemsList.stream()
        .filter(item -> item.getName().toLowerCase().contains(searchInput.toLowerCase()) || item.getDescription().toLowerCase().contains(searchInput.toLowerCase()))
        .collect(Collectors.toList()));
    model.addAttribute("currency", new String("CZK"));
    return "index";
  }

  @RequestMapping(value = "/more-filters", method = RequestMethod.GET)
  public String redirectToMoreFilter(Model model) {
    model.addAttribute("items", shopItemsList);
    model.addAttribute("currency", new String("CZK"));
    return "morefilters";
  }

  @RequestMapping(value = "/filter-by-type/{type}", method = RequestMethod.GET)
  public String filterByType(Model model, @PathVariable String type) {
    model.addAttribute("items", shopItemsList.stream()
        .filter(item -> item.getType().equals(type))
        .collect(Collectors.toList()));
    model.addAttribute("currency", new String("CZK"));
    return "morefilters";
  }

  @RequestMapping(value = "/price-in-eur", method = RequestMethod.GET)
  public String showPricesInEuro(Model model) {
    model.addAttribute("items", shopItemsList.stream()
        .map(item -> new ShopItem(item.getName(), item.getDescription(), item.getPrice() * 0.037f,
            item.getQuantity(), item.getType()))
        .collect(Collectors.toList()));
    model.addAttribute("currency", "EUR");
    return "morefilters";
  }

  @RequestMapping(value = "/price-in-original", method = RequestMethod.GET)
  public String showPricesInOriginalCurrency(Model model) {
    model.addAttribute("items", shopItemsList);
    model.addAttribute("currency", new String("CZK"));
    return "morefilters";
  }

  @RequestMapping(path = "/search-by-price", method = RequestMethod.POST)
  public String searchByPrice(@RequestParam String searchMode,
                              @RequestParam(defaultValue = "0") Integer number,
                              Model model) {
    switch (searchMode) {
      case "Above":
        model.addAttribute("items", shopItemsList.stream()
            .filter(item -> item.getPrice() > Float.valueOf(number))
            .collect(Collectors.toList()));
        break;
      case "Below":
        model.addAttribute("items", shopItemsList.stream()
            .filter(item -> item.getPrice() < Float.valueOf(number))
            .collect(Collectors.toList()));
        break;
      case "Exactly":
        model.addAttribute("items", shopItemsList.stream()
            .filter(item -> item.getPrice() == Float.valueOf(number))
            .collect(Collectors.toList()));
        break;
    }
    model.addAttribute("currency", new String("CZK"));
    return "morefilters";
  }
}
