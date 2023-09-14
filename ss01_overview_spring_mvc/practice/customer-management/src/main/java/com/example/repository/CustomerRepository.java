package com.example.repository;

import com.example.model.Customer;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CustomerRepository implements ICustomerRepository{
    private static List<Customer> customerList = new ArrayList<>();
    static {
        customerList.add(new Customer(1,"Nguyen Khac Nhat","nhat@codegym.com","Hà Nội"));
        customerList.add(new Customer(2,"Dang Huy Hoa","hoa.dang@codegym.com","Đà Nẵng"));
        customerList.add(new Customer(3,"Le Thi Chau","chau.le@codegym.com ","Hà Nội"));
        customerList.add(new Customer(4,"Nguyen Thuy Duong","duong.nguyen@codegym.com","Sài Gòn"));
        customerList.add(new Customer(5,"CodeGym","codegym@codegym.com","Việt Nam"));
    }


    @Override
    public List<Customer> findAll() {
        return customerList;
    }
}
