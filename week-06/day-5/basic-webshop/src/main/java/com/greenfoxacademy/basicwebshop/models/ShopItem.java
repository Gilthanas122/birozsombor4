package com.greenfoxacademy.basicwebshop.models;

public class ShopItem {
  private String name;
  private String description;
  private float price;
  private int quantity;
  private String type;

  public ShopItem(String name, String description, float price, int quantity, String type) {
    this.name = name;
    this.description = description;
    this.price = price;
    this.quantity = quantity;
    this.type = type;
  }

  public String getName() {
    return name;
  }

  public String getDescription() {
    return description;
  }

  public float getPrice() {
    return price;
  }

  public int getQuantity() {
    return quantity;
  }

  public String getType() {
    return type;
  }
}
