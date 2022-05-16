package com.example.usermanagement_mvc.service;

import com.example.usermanagement_mvc.model.Customer;

import java.util.List;

public interface ICustomerService {
    List<Customer> findAll();
    void save(Customer customer);
    Customer findById(int id);
    void updateById(int id , Customer customer);
    void removeById(int id);
    List<Customer> searchByName(String name);
}
