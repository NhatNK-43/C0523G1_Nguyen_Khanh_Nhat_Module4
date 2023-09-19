package com.example.repository;

import com.example.model.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository
public class ProductRepository implements IProductRepository{
    private static List<Product> productList = new ArrayList<>();
    static {
        productList.add(new Product(1,"Telephone",15000000,"Ram 8GB, Memory: 256GB","SamSung"));
        productList.add(new Product(2,"Television",12000000,"Size: 50inch","Sony"));
        productList.add(new Product(3,"Washing machine",11000000,"Inverter, 10kg","SamSung"));
    }

    @Override
    public int getIndexById(int id) {
        return productList.indexOf(new Product(id));
    }

    @Override
    public List<Product> findAll() {
        return productList;
    }

    @Override
    public void create(Product product) {
        productList.add(product);
    }

    @Override
    public void update(int id, Product product) {
        productList.set(getIndexById(id),product);
    }

    @Override
    public void delete(int id) {
        productList.remove(getIndexById(id));
    }

    @Override
    public List<Product> showListSearch(String name) {
        List<Product> productListSearch = new ArrayList<>();
        for(Product product:productList){
            if(product.getName().toLowerCase().contains(name.toLowerCase())){
                productListSearch.add(product);
            }
        }
        return productListSearch;
    }
}
