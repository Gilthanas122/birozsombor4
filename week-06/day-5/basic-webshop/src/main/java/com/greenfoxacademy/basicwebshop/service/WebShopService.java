package com.greenfoxacademy.basicwebshop.service;

import com.greenfoxacademy.basicwebshop.models.ShopItem;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

@Service
public class WebShopService {
  private List<ShopItem> shopItemsList;

  public WebShopService() {
    this.shopItemsList = initAllItem();
  }

  public List<ShopItem> initAllItem() {
    return Arrays.asList(
        new ShopItem("Running shoes", "Nike running shoes for every day sport", 1000, 5, "dress"),
        new ShopItem("Printer", "Some HP printer that will print pages", 3000, 2, "device"),
        new ShopItem("Coca cola", "0.5l standard coke", 25, 0, "food"),
        new ShopItem("Wokin", "Chicken with fried rice and WOKIN sauce", 119, 100, "food"),
        new ShopItem("T-shirt", "Blue with a corgi", 300, 1, "dress")
    );
  }

  public List<ShopItem> getShopItemsList() {
    return this.shopItemsList;
  }

  public List<ShopItem> getOnlyAvailableItems() {
    return this.shopItemsList.stream()
        .filter(item -> item.getQuantity() > 0)
        .collect(Collectors.toList());
  }

  public List<ShopItem> getListByCheapestFirst() {
    return shopItemsList.stream()
        .sorted((item1, item2) -> Float.compare(item1.getPrice(), item2.getPrice()))
        .collect(Collectors.toList());
  }

  public List<ShopItem> getItemsWhichContainsNike() {
    return shopItemsList.stream()
        .filter(item -> item.getName().toLowerCase().contains("nike") || item.getDescription().toLowerCase().contains("nike"))
        .collect(Collectors.toList());
  }

  public double getAverageStock() {
    return shopItemsList.stream()
        .mapToDouble(item -> item.getQuantity())
        .average()
        .orElseGet(() -> 0);
  }

  public List<ShopItem> getMostExpensive() {
    return shopItemsList.stream()
        .sorted(Comparator.comparingDouble(ShopItem::getPrice).reversed())
        .limit(1)
        .collect(Collectors.toList());
  }

  public List<ShopItem> getItemsByName(String searchInput) {
    return shopItemsList.stream()
        .filter(item -> item.getName().toLowerCase().contains(searchInput.toLowerCase()) || item.getDescription().toLowerCase().contains(searchInput.toLowerCase()))
        .collect(Collectors.toList());
  }

  public List<ShopItem> getItemsByType(String type) {
    return shopItemsList.stream()
        .filter(item -> item.getType().equals(type))
        .collect(Collectors.toList());
  }

  public List<ShopItem> getItemsByPrice(String searchMode, int number) {
    switch (searchMode) {
      case "Above":
        return shopItemsList.stream()
            .filter(item -> item.getPrice() > Float.valueOf(number))
            .collect(Collectors.toList());
      case "Below":
        return shopItemsList.stream()
            .filter(item -> item.getPrice() < Float.valueOf(number))
            .collect(Collectors.toList());
      case "Exactly":
        return shopItemsList.stream()
            .filter(item -> item.getPrice() == Float.valueOf(number))
            .collect(Collectors.toList());
    }
    return null;
  }

  public void changePricesToEuro() {
    ShopItem.isOriginalCurrency = false;
    this.shopItemsList = initAllItem();
  }

  public void changePricesToOriginalCurrency() {
    ShopItem.isOriginalCurrency = true;
    this.shopItemsList = initAllItem();
  }


}
