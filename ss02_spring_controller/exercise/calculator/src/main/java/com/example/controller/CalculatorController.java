package com.example.controller;

import com.example.service.Calculator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalculatorController {
    @Autowired
    private Calculator calculator;
   @GetMapping("")
   public String home(){
       return "calculator";
   }

   @PostMapping("/calculator")
    public String calculator(@RequestParam double number1,
                             @RequestParam double number2,
                             @RequestParam String operator,
                             Model model){
       String result = calculator.calculator(number1,number2,operator);
       model.addAttribute("result",result);
       model.addAttribute("number1",number1);
       model.addAttribute("number2",number2);
       return "calculator";
   }
}
