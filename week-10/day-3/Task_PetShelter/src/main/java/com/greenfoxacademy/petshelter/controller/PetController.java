package com.greenfoxacademy.petshelter.controller;

import com.greenfoxacademy.petshelter.model.Human;
import com.greenfoxacademy.petshelter.model.Pet;
import com.greenfoxacademy.petshelter.service.HumanService;
import com.greenfoxacademy.petshelter.service.PetService;
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
public class PetController {

  private PetService petService;
  private HumanService humanService;

  @Autowired
  public PetController(PetService petService, HumanService humanService) {
    this.petService = petService;
    this.humanService = humanService;
  }

  @GetMapping("/list-pets")
  public String getPets(Model model,
                        @RequestParam(required = false) boolean hasError,
                        @ModelAttribute Pet pet) {
    model.addAttribute("hasError", hasError);
    model.addAttribute("listOfPets", petService.getAllPet());
    model.addAttribute("pet", hasError ? pet : new Pet());
    model.addAttribute("listOfHumans", humanService.getAllHuman());
    return "pets";
  }

  @PostMapping("/add-pet")
  public String addNewPet(@ModelAttribute Pet pet, Long humanId,
                          RedirectAttributes redirectAttributes) {
    redirectAttributes.addFlashAttribute(pet);
    if (pet.getName().isEmpty() || petService.isPetNameExist(pet.getName())) {
      return "redirect:/list-pets?hasError=true";
    }
    petService.savePetToHuman(pet, humanId);
    return "redirect:/list-pets";
  }

  @GetMapping("/delete/pet/{id}")
  public String deletePetById(@PathVariable Long id) {
    petService.deletePetById(id);
    return "redirect:/list-pets";
  }

  @GetMapping("/edit/pet/{id}")
  public String getPetEditPageWithId(Model model, @PathVariable Long id) {
    model.addAttribute("pet", petService.getPetById(id));
    model.addAttribute("listOfHumans", humanService.getAllHuman());
    return "editPet";
  }

  @PostMapping("/edit/pet/{id}")
  public String editPetById(@ModelAttribute Pet pet, Long humanId) {
    petService.savePetToHuman(pet, humanId);
    return "redirect:/list-pets";
  }
}
