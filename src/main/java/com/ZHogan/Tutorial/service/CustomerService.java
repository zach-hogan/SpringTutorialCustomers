package com.ZHogan.Tutorial.service;

import com.ZHogan.Tutorial.model.Customer;
import com.ZHogan.Tutorial.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CustomerService {
    @Autowired
    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }


    public List<Customer> getCustomers(){
        return customerRepository.findAll();
    }

    public List<Customer> findJohn(){
        return customerRepository.findByName("John");
    }

    public void addCustomer(Customer customer) {
        customerRepository.save(customer);
    }

    public void deleteAllCustomers(){
        customerRepository.deleteAll();
    }
}
