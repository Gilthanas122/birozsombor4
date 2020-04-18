package com.greenfoxacademx.springstart.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloToAllTheWorldController {

  String[] hellos = {"Mirëdita", "Ahalan", "Parev", "Zdravei", "Nei Ho", "Dobrý den", "Ahoj", "Goddag", "Goede dag, Hallo", "Hello", "Saluton", "Hei", "Bonjour",
      "Guten Tag", "Gia'sou", "Aloha", "Shalom", "Namaste", "Namaste", "Jó napot", "Halló", "Helló", "Góðan daginn", "Halo", "Aksunai", "Qanuipit", "Dia dhuit",
      "Salve", "Ciao", "Kon-nichiwa", "An-nyong Ha-se-yo", "Salvëte", "Ni hao", "Dzien' dobry", "Olá", "Bunã ziua", "Zdravstvuyte", "Hola", "Jambo", "Hujambo", "Hej",
      "Sa-wat-dee", "Merhaba", "Selam", "Vitayu", "Xin chào", "Hylo", "Sut Mae", "Sholem Aleychem", "Sawubona"};
  int randomIndex = 0;

  @RequestMapping(value = "/web/hellostranger")
  public String greetInRandomLanguage(Model model,
                                      @RequestParam(defaultValue = "User", required = false) String name,
                                      @RequestParam(defaultValue = "16", required = false) String fontSize,
                                      @RequestParam(defaultValue = "50,100,150", required = false) String rgb) {
    randomIndex = (int) (Math.random() * hellos.length);
    model.addAttribute("hello", hellos[randomIndex]);
    model.addAttribute("name", name);
    model.addAttribute("fontSize", fontSize);
    model.addAttribute("rgb", rgb);
    return "hellostranger";
  }
}
