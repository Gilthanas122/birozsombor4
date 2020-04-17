package com.greenfoxacademy.basicwebshop.models;

import java.util.Arrays;
import java.util.List;

public class WebShop {
  private List<ShopItem> items;

  public WebShop() {
    items = Arrays.asList(
        new ShopItem("Running shoes", "Nike running shoes for every day sport", 1000, 5,"dress"),
        new ShopItem("Printer", "Some HP printer that will print pages", 3000, 2,"device"),
        new ShopItem("Coca cola", "0.5l standard coke", 25, 0,"food"),
        new ShopItem("Wokin", "Chicken with fried rice and WOKIN sauce", 119, 100,"food"),
        new ShopItem("T-shirt", "Blue with a corgi", 300, 1,"dress")
    );
  }
}
