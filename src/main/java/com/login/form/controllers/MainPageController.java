package com.login.form.controllers;

import com.login.form.configurations.services.ProductService;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/main")
public class MainPageController {

  private final ProductService productService;

  public MainPageController(ProductService productService) {
    this.productService = productService;
  }

  @GetMapping
  public String main(Authentication auth, Model model) {
    model.addAttribute("username", auth.getName());
    model.addAttribute("products", productService.findAll());

    return "main.html";
  }

}
