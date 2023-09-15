package com.example.service;

import org.springframework.stereotype.Service;

@Service
public class Calculator {
    public String calculator(double number1, double number2, String operator) {
        String result = "Result " + operator + ": ";
        if (number2 == 0 && operator.equals("Division")) {
            result += "Division by 0 error!";
        } else {
            switch (operator) {
                case "Addition":
                    result += number1 + number2;
                    break;
                case "Subtraction":
                    result += number1 - number2;
                    break;
                case "Multiplication":
                    result += number1 * number2;
                    break;
                case "Division":
                    result += number1 / number2;
                    break;
            }
        }
        return result;
    }
}
