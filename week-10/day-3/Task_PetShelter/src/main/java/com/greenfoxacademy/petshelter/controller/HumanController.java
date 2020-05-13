package com.greenfoxacademy.petshelter.controller;

import com.greenfoxacademy.petshelter.model.Human;
import com.greenfoxacademy.petshelter.service.HumanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class HumanController {

  private HumanService humanService;

  @Autowired
  public HumanController(HumanService humanService) {
    this.humanService = humanService;
  }

  @GetMapping("/")
  public String getIndexPage(Model model, @ModelAttribute Human human,
                             @RequestParam(required = false) boolean hasError) {
    model.addAttribute("hasError", hasError);
    model.addAttribute("human", hasError ? human : new Human());
    model.addAttribute("listOfHuman", humanService.getAllHuman());
    return "index";
  }

  @PostMapping("/add-human")
  public String addNewHuman(@ModelAttribute Human human, RedirectAttributes attributes) {
    attributes.addFlashAttribute(human);
    if (human.getName().isEmpty() || humanService.isHumanNameExist(human.getName())){
      return "redirect:/?hasError=true";
    }
    humanService.saveHuman(human);
    return "redirect:/";
  }

  @GetMapping("/delete/{id}")
  public String deleteHumanById(@PathVariable Long id) {
    humanService.deleteHumanById(id);
    return "redirect:/";
  }

  @GetMapping("/edit/{id}")
  public String getEditPageWithId(Model model, @PathVariable Long id) {
    model.addAttribute("human", humanService.getHumanById(id));
    return "edit";
  }

  @PostMapping("/edit/{id}")
  public String editHumanById(@ModelAttribute Human human) {
    humanService.saveHuman(human);
    return "redirect:/";
  }

}
