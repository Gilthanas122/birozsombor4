package com.greenfoxacademy.rest.model;

public class DoUntil {

  private Integer until;
  private Integer result;

  public DoUntil() {
  }

  public DoUntil(Integer until) {
    this.until = until;
  }

  public Integer getUntil() {
    return until;
  }

  public void setUntil(Integer until) {
    this.until = until;
  }

  public Integer getResult() {
    return result;
  }

  public void setResult(Integer result) {
    this.result = result;
  }

  public void setResultAsFactorialAction() {
    this.result = 1;
    for (int i = 1; i <= this.until; i++) {
      this.result *= i;
    }
  }

  public void setResultAsSumAction() {
    this.result = 0;
    for (int i = 1; i <= this.until; i++) {
      this.result += i;
    }
  }

  public void setResultAsWithAction(String action) {
    switch (action) {
      case "sum":
        this.setResultAsSumAction();
        break;
      case "factor":
        this.setResultAsFactorialAction();
        break;
    }
  }
}
