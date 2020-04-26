package com.greenfoxacademy.bankofsimba.model;

public class BankAccount {
  private String name;
  private int balance;
  private String animalType;
  private boolean king;
  private String alignment;

  public BankAccount() {
  }

  public BankAccount(String name, int balance, String animalType, String alignment) {
    this(name, balance, animalType, false, alignment);
  }

  public BankAccount(String name, int balance, String animalType, boolean isKing, String alignment) {
    this.name = name;
    this.balance = balance;
    this.animalType = animalType;
    this.king = isKing;
    this.alignment = alignment;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getBalance() {
    return balance;
  }

  public void setBalance(int balance) {
    this.balance = balance;
  }

  public String getAnimalType() {
    return animalType;
  }

  public void setAnimalType(String animalType) {
    this.animalType = animalType;
  }

  public boolean getKing() {
    return king;
  }

  public void setKing(boolean king) {
    this.king = king;
  }

  public String getAlignment() {
    return alignment;
  }

  public void setAlignment(String alignment) {
    this.alignment = alignment;
  }
}
