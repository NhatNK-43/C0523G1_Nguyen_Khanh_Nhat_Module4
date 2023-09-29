package com.example.cart.controller;

import com.example.cart.model.Cart;
import com.example.cart.model.Product;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import java.util.Map;

@Controller
@RequestMapping("/carts")
public class CartController {
    @GetMapping("")
    public String showListCart(@SessionAttribute(value = "cart", required = false) Cart cart, Model model){
        Map<Product, Integer> productMap = cart.getProducts();
        model.addAttribute("productMap", productMap);
        double totalPayment = cart.countTotalPayment();
        model.addAttribute("totalPayment",totalPayment);
        return "list-cart";
    }
}
