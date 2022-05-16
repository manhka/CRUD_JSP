package com.example.usermanagement_mvc.service;

import com.example.usermanagement_mvc.model.Customer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CustomerServiceImpl implements ICustomerService {
    private static Map<Integer, Customer> customerMap;

    static {
        customerMap = new HashMap<>();
        customerMap.put(1, new Customer(1, "John", "john@codegym.vn", "Hanoi"));
        customerMap.put(2, new Customer(2, "Bill", "bill@codegym.vn", "Danang"));
        customerMap.put(3, new Customer(3, "Alex", "alex@codegym.vn", "Saigon"));
        customerMap.put(4, new Customer(4, "Adam", "adam@codegym.vn", "Beijin"));
        customerMap.put(5, new Customer(5, "Sophia", "sophia@codegym.vn", "Miami"));
        customerMap.put(6, new Customer(6, "Rose", "rose@codegym.vn", "Newyork"));
    }

    @Override
    public List<Customer> findAll() {
        return new ArrayList<>(customerMap.values());
    }

    @Override
    public void save(Customer customer) {
        customerMap.put(customer.getId(), customer);
    }

    @Override
    public Customer findById(int id) {
        return customerMap.get(id);
    }

    @Override
    public void updateById(int id, Customer customer) {
        customerMap.put(id, customer);
    }

    @Override
    public void removeById(int id) {
        customerMap.remove(id);
    }

    @Override
    public List<Customer> searchByName(String name) {
        List<Customer> customerSearch = new ArrayList<>();
        for (int i = 1; i <= customerMap.size(); i++) {
            if (customerMap.get(i).getName().contains(name)) {
                customerSearch.add(customerMap.get(i));
            }
        }
        return customerSearch;
    }
}
