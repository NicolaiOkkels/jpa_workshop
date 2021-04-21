package com.example.demo.controller;

import com.example.demo.model.Product;
import com.example.demo.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ProductController {

    ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/")
    public String index(Model model){
        model.addAttribute("products", productService.findAll());
        return "index";
    }

    @GetMapping("/create")
    public String create(){
        return "create";
    }

    @GetMapping("/update/{id}")
    public String update(@PathVariable("id") long id, Model model){
        model.addAttribute("product", productService.findProduct(id));
        return "update";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute("product") Product product){
        return "update";
    }

    @PostMapping("/delete")
    public String delete(@ModelAttribute Product product){
        productService.deleteProduct(product);
        return "redirect:/";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute("product") Product product){
        return "redirect:/";
    }

}
