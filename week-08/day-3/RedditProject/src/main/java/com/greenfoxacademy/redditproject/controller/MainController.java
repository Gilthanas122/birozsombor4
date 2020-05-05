package com.greenfoxacademy.redditproject.controller;

import com.greenfoxacademy.redditproject.model.Post;
import com.greenfoxacademy.redditproject.model.User;
import com.greenfoxacademy.redditproject.service.PostService;
import com.greenfoxacademy.redditproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {

  private PostService postService;
  private UserService userService;

  @Autowired
  public MainController(PostService postService, UserService userService) {
    this.postService = postService;
    this.userService = userService;
  }

  @GetMapping("/")
  public String redirectToMain() {
    if (userService.isActiveAnyUser()) {
      return "redirect:/list";
    } else {
      return "redirect:/login";
    }
  }

  @GetMapping(value = {"/list"})
  public String getDefaultHomePage(Model model) {
    model.addAttribute("posts", postService.getPostsForHomePage());
    model.addAttribute("pageNumbers", postService.getHowManyPageDoWeNeed());
    return "home";
  }

  @GetMapping(value = {"/list/{pageNumber}"})
  public String getHomePage(Model model, @PathVariable(required = false) Integer pageNumber) {
    model.addAttribute("posts", postService.getPostsWithPageNumber(pageNumber));
    model.addAttribute("pageNumbers", postService.getHowManyPageDoWeNeed());
    return "home";
  }

  @GetMapping("/submit")
  public String getViewOfSubmit(Model model) {
    model.addAttribute("newPost", new Post());
    return "submit";
  }

  @PostMapping("/submit")
  public String submitANewPost(@ModelAttribute Post newPost) {
    postService.addNewPostToDatabase(newPost);
    return "redirect:/list";
  }

  @GetMapping("/{option}/{id}")
  public String manageVoting(@PathVariable String option, @PathVariable long id) {
    postService.updatePostCounterField(option, id);
    return "redirect:/list";
  }

  @GetMapping(value = "/register")
  public String getRegisterView(Model model,
                                @RequestParam(required = false) Boolean passwordVerificationFailed,
                                @RequestParam(required = false) Boolean usernameVerificationFailed) {
    model.addAttribute("newUser", new User());
    if (passwordVerificationFailed != null) {
      model.addAttribute("passwordVerificationFailed", passwordVerificationFailed);
    }
    if (usernameVerificationFailed != null) {
      model.addAttribute("usernameVerificationFailed", usernameVerificationFailed);
    }
    return "register";
  }

  @PostMapping(value = "/register")
  public String registerNewUser(@ModelAttribute User user, String passwordVerification) {
    if (userService.isUserValid(user, passwordVerification)) {
      userService.addNewUser(user);
      return "redirect:/login";
    }
    if (userService.isUserInvalid(user, passwordVerification)) {
      return "redirect:/register?passwordVerificationFailed=true&usernameVerificationFailed=true";
    } else if (!userService.isPasswordValid(user, passwordVerification)) {
      return "redirect:/register?passwordVerificationFailed=true";
    } else {
      return "redirect:/register?usernameVerificationFailed=true";
    }
  }

  @GetMapping(value = "/login")
  public String getLoginWithUserView(Model model,
                                     @RequestParam(required = false) Boolean invalidUserdata) {
    if (invalidUserdata != null) {
      model.addAttribute("invalidUserdata", invalidUserdata);
    }
    return "login";
  }

  @PostMapping(value = "/login")
  public String getUserDatasFromLoginView(String username, String password, Model model) {
    if (userService.validateUserData(username, password)) {
      userService.setUserActive(username);
      return "redirect:/list";
    }
    return "redirect:/login?invalidUserdata=true";
  }

  @GetMapping(value = "/logout")
  public String getBackToLogin() {
    userService.setActiveUserToInactive();
    return "redirect:/login";
  }
}
