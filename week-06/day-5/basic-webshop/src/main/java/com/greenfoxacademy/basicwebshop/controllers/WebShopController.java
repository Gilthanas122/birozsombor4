package com.greenfoxacademy.basicwebshop.controllers;

import com.greenfoxacademy.basicwebshop.service.WebShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class WebShopController {

  private WebShopService webShopService;

  @Autowired
  public WebShopController(WebShopService webShopService) {
    this.webShopService = webShopService;
  }

  @ResponseBody
  @GetMapping(value = "/webshop")
  public String greetTheWorld() {
    return "Hello World";
  }

  @GetMapping(value = "")
  public String redirectToHomePage(Model model) {
    model.addAttribute("items", webShopService.getShopItemsList());
    return "index";
  }

  @GetMapping(value = "/only-available")
  public String getOnlyAvailableItems(Model model) {
    model.addAttribute("items", webShopService.getOnlyAvailableItems());
    return "index";
  }

  @GetMapping(value = "/cheapest-first")
  public String sortAscendingOrderByPrice(Model model) {
    model.addAttribute("items", webShopService.getListByCheapestFirst());
    return "index";
  }

  @GetMapping(value = "/contains-nike")
  public String getItemsWhichAreNikes(Model model) {
    model.addAttribute("items", webShopService.getItemsWhichContainsNike());
    return "index";
  }

  @GetMapping(value = "/average-stock")
  public String getAverageStock(Model model) {
    model.addAttribute("averageOfStock", webShopService.getAverageStock());
    return "averageofstock";
  }

  @GetMapping(value = "/most-expensive")
  public String getMostExpensive(Model model) {
    model.addAttribute("items", webShopService.getMostExpensive());
    return "index";
  }

  @PostMapping(path = "/search")
  public String searchByNames(String searchInput, Model model) {
    model.addAttribute("items", webShopService.getItemsByName(searchInput));
    return "index";
  }

  @GetMapping(value = "/more-filters")
  public String redirectToMoreFilter(Model model) {
    model.addAttribute("items", webShopService.getShopItemsList());
    return "morefilters";
  }

  @GetMapping(value = "/filter-by-type/{type}")
  public String filterByType(Model model, @PathVariable String type) {
    model.addAttribute("items", webShopService.getItemsByType(type));
    model.addAttribute("selectedType", type);
    return "morefilters";
  }

  @GetMapping(value = "/price-in-eur")
  public String showPricesInEuro(Model model) {
    webShopService.changePricesToEuro();
    model.addAttribute("items", webShopService.getShopItemsList());
    return "morefilters";
  }

  @GetMapping(value = "/price-in-original")
  public String showPricesInOriginalCurrency(Model model) {
    webShopService.changePricesToOriginalCurrency();
    model.addAttribute("items", webShopService.getShopItemsList());
    return "morefilters";
  }

  @PostMapping(path = "/search-by-price")
  public String searchByPrice(@RequestParam String searchMode,
                              @RequestParam(defaultValue = "0") Integer number,
                              Model model) {
    model.addAttribute("items", webShopService.getItemsByPrice(searchMode, number));
    return "morefilters";
  }
}
