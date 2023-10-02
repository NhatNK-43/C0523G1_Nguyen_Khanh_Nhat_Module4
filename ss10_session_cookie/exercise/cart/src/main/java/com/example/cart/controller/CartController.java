package com.example.cart.controller;

import com.example.cart.dto.Cart;
import com.example.cart.model.Product;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("change-amount/{id}/{amount}")
    public String changeAmount(@PathVariable int id, @PathVariable int amount,@SessionAttribute(value = "cart", required = false) Cart cart, Model model){
        cart.setAmount(id,amount);
        return "redirect:/carts";
    }
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable int id, @SessionAttribute(value = "cart", required = false) Cart cart){
        cart.delete(id);
        return "redirect:/carts";
    }
}
