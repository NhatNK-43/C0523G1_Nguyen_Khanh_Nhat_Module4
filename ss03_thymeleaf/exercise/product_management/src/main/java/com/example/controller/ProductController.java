package com.example.controller;

import com.example.model.Product;
import com.example.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class ProductController {
    @Autowired
    private IProductService productService;

    @GetMapping("")
    public String showList(Model model){
        List<Product> productList = productService.findAll();
        model.addAttribute("productList",productList);
        return "list";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam int idDelete, RedirectAttributes redirectAttributes, Model model){
        productService.delete(idDelete);
        redirectAttributes.addFlashAttribute("mess","Deleted successfully!");
        List<Product> productList = productService.findAll();
        model.addAttribute("productList",productList);
        return "redirect:/";
    }

    @GetMapping("/create")
    public String showFormCreate(Model model){
        model.addAttribute("product", new Product());
        return "create";
    }
    @PostMapping("/create")
    public String create(@ModelAttribute Product product, RedirectAttributes redirectAttributes, Model model){
        productService.create(product);
        redirectAttributes.addFlashAttribute("mess","Create Successfully!");
        List<Product> productList = productService.findAll();
        model.addAttribute("productList",productList);
        return "redirect:/";
    }

    @PostMapping("/update")
    public String update(@RequestParam int idUpdate,
                         @RequestParam String nameUpdate,
                         @RequestParam int priceUpdate,
                         @RequestParam String descriptionUpdate,
                         @RequestParam String manufacturerUpdate,
                         RedirectAttributes redirectAttributes, Model model){
        productService.update(idUpdate,new Product(idUpdate,nameUpdate,priceUpdate,descriptionUpdate,manufacturerUpdate));
        redirectAttributes.addFlashAttribute("mess","Update Successfully!");
        List<Product> productList = productService.findAll();
        model.addAttribute("productList",productList);
        return "redirect:/";
    }

    @GetMapping("/search")
    public String searchByName(@RequestParam String nameSearch, RedirectAttributes redirectAttributes, Model model){
        List<Product> productList = productService.showListSearch(nameSearch);
        model.addAttribute("nameSearch",nameSearch);
        model.addAttribute("productList",productList);
        return "list";
    }
}
