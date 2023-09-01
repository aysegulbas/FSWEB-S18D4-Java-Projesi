package com.workintech.bank.service;

import com.workintech.bank.entity.Customer;

import java.util.List;

public interface CustomerService {
    List<Customer> findAll();
    void delete(Customer customer);
    Customer findById(int id);
    Customer save(Customer customer);
}
