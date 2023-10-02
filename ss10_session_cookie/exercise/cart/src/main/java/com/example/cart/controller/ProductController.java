package com.example.cart.controller;

import com.example.cart.dto.Cart;
import com.example.cart.model.Product;
import com.example.cart.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/products")
@SessionAttributes("cart")
public class ProductController {
    @Autowired
    private IProductService productService;
    @ModelAttribute("cart")
    public Cart init(){
        return new Cart();
    }
    @GetMapping("")
    public String showList(Model model){
        List<Product> productList = productService.findAll();
        model.addAttribute("product", new Product());
        model.addAttribute("productList",productList);
        return "list";
    }

    @GetMapping("add-to-cart")
    public String addToCart(@RequestParam int id, @SessionAttribute(value = "cart", required = false) Cart cart){
        Product product = productService.findById(id);
        cart.addProduct(product);
        return "redirect:/products";
    }
}
