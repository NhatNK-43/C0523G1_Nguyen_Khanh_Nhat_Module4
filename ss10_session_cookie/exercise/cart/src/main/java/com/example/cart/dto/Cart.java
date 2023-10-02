package com.example.cart.dto;

import com.example.cart.model.Product;

import java.util.HashMap;
import java.util.Map;

public class Cart {
    private Map<Product,Integer> productMap = new HashMap<>();

    public Cart() {
    }

    public Map<Product,Integer> getProducts() {
        return productMap;
    }

    public void addProduct (Product product){
        if(productMap.containsKey(product)){
            Integer amount = productMap.get(product);
            productMap.replace(product,amount + 1);
        }else {
            productMap.put(product,1);
        }
    }

    public Float countTotalPayment(){
        float payment = 0;
        for (Map.Entry<Product, Integer> entry : productMap.entrySet()) {
            payment += entry.getKey().getPrice() * (float) entry.getValue();
        }
        return payment;
    }

    public void setAmount(int id, int amount){
        for (Product product : productMap.keySet()) {
            if (product.getId()==id){
                productMap.replace(product, amount);
            }
        }
    }
    public void delete(int id){
        for (Product product : productMap.keySet()) {
            if (product.getId()==id){
                productMap.remove(product,productMap.get(product));
                break;
            }
        }
    }
}