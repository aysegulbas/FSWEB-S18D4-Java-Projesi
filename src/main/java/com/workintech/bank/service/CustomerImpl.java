package com.workintech.bank.service;

import com.workintech.bank.dao.CustomerRepository;
import com.workintech.bank.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerImpl implements CustomerService{
    private CustomerRepository customerRepository;
@Autowired
    public CustomerImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public void delete(Customer customer) {
customerRepository.delete(customer);
    }

    @Override
    public Customer findById(int id) {
        Optional<Customer> customerOptional=customerRepository.findById(id);
        if(customerOptional.isPresent()){return customerOptional.get();}
        return null;
    }

    @Override
    public Customer save(Customer customer) {
        return customerRepository.save(customer);
    }
}
