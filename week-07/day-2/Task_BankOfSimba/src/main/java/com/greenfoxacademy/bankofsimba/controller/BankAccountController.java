package com.greenfoxacademy.bankofsimba.controller;

import com.greenfoxacademy.bankofsimba.model.BankAccount;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class BankAccountController {

  private List<BankAccount> bankAccountList = new ArrayList<>();

  public BankAccountController() {
    bankAccountList.add(new BankAccount("Mufasza", 5000, "lion", true, "good"));
    bankAccountList.add(new BankAccount("Nala", 1500, "lion", "good"));
    bankAccountList.add(new BankAccount("Pumbaa", 200, "warthog", "good"));
    bankAccountList.add(new BankAccount("Timon", 150, "meerkat", "good"));
    bankAccountList.add(new BankAccount("Zordon", 10000, "lion", "bad"));
  }

  @GetMapping(value = ("/show"))
  public String showSimbasAccount(Model model) {
    BankAccount simba = new BankAccount("Simba", 2000, "lion", "good");
    model.addAttribute("simba", simba);
    return "simba";
  }

  @GetMapping(value = ("/utext"))
  public String show(Model model) {
    String message = "This is an <em>HTML</em> text. <b>Enjoy yourself!</b>";
    model.addAttribute("message", message);
    return "simba";
  }

  @GetMapping(value = ("/accounts"))
  public String showAccounts(Model model) {
    model.addAttribute("accounts", bankAccountList);
    model.addAttribute("accountTemplate", new BankAccount());
    return "accounts";
  }

  @PostMapping(value = ("/raise"))
  public String raiseBalance(String selectedAccountName, Model model) {
    for (BankAccount account : bankAccountList) {
      if (account.getName().equals(selectedAccountName)) {
        int holder = account.getBalance();
        if (account.getKing()) {
          holder += 100;
        } else {
          holder += 10;
        }
        account.setBalance(holder);
      }
    }
    return "redirect:/accounts";
  }

  @PostMapping(value = ("/add"))
  public String addNewAccount(@ModelAttribute BankAccount newAccount) {
    bankAccountList.add(newAccount);
    return "redirect:/accounts";
  }

  //unnecesseary (just for case if you want to use /raise to get )
  @GetMapping(value = ("/raise"))
  public String returnRaiseView(Model model) {
    model.addAttribute("accountTemplate", new BankAccount());
    model.addAttribute("accounts", bankAccountList);
    return "raise";
  }
}
