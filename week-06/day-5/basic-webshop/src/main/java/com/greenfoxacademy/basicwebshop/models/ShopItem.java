package com.greenfoxacademy.basicwebshop.models;

public class ShopItem {
  public static boolean isOriginalCurrency = true;
  private String name;
  private String description;
  private float price;
  private int quantity;
  private String type;
  private String currency;

  public ShopItem(String name, String description, float price, int quantity, String type) {
    this.name = name;
    this.description = description;
    this.price = getPriceAsSelectedCurrency(price);
    this.quantity = quantity;
    this.type = type;
    this.currency = getCurrencyAsSelectedCurrency();
  }

  private String getCurrencyAsSelectedCurrency() {
    if (isOriginalCurrency) {
      return "CZK";
    } else {
      return "EUR";
    }
  }

  private float getPriceAsSelectedCurrency(float price) {
    if (isOriginalCurrency) {
      return price;
    } else {
      return price * 0.037f;
    }
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

  public String getCurrency() {
    return currency;
  }
}
