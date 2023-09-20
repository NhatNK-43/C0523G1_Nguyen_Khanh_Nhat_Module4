package com.example.repository;

import com.example.model.Product;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
@Repository
public class ProductRepository implements IProductRepository{
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Product findById(int id) {
        return entityManager.find(Product.class,id);
    }

    @Override
    public List<Product> findAll() {
        TypedQuery<Product> query = entityManager.createQuery("from Product",Product.class);
        //SQL thuần
        //        TypedQuery<Student> query = (TypedQuery<Student>) entityManager.createNativeQuery("select * from student", Student.class);
        return query.getResultList();
    }

    @Transactional
    @Override
    public boolean create(Product product) {
        try {
            entityManager.persist(product);
        } catch (Exception e){
            return false;
        }
        return true;
    }

    @Transactional
    @Override
    public boolean update(int id, Product product) {
        try {
            Product productUpdate = findById(id);
            productUpdate.setName(product.getName());
            productUpdate.setPrice(product.getPrice());
            productUpdate.setDescription(product.getDescription());
            productUpdate.setManufacturer(product.getManufacturer());
            entityManager.merge(productUpdate);
        } catch (Exception e){
            return false;
        }
        return true;
    }

    @Transactional
    @Override
    public boolean delete(int id) {
        try {
            Product productDelete = findById(id);
            entityManager.remove(productDelete);
        } catch (Exception e){
            return false;
        }
        return true;
    }

    @Override
    public List<Product> showListSearch(String name) {
        List<Product> productList = findAll();
        List<Product> productListSearch = new ArrayList<>();
        for(Product product:productList){
            if(product.getName().toLowerCase().contains(name.toLowerCase())){
                productListSearch.add(product);
            }
        }
        return productListSearch;
    }
}
