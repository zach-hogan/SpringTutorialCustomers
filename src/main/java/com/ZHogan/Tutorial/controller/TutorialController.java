package com.ZHogan.Tutorial.controller;

import com.ZHogan.Tutorial.model.Customer;
import com.ZHogan.Tutorial.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1")
public class TutorialController {
    @Autowired
    private final CustomerService customerService;
    @Autowired
    public TutorialController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/greet")
    public String greet() {
        return "Hello";
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Customer>> getCustomers(){
        List<Customer> customers = customerService.getCustomers();
        return new ResponseEntity<>(customers, HttpStatus.OK);
    }

    @GetMapping("/findJohn")
    public ResponseEntity<List<Customer>> getJohn() {
        List<Customer> johns = customerService.findJohn();
        return new ResponseEntity<>(johns, HttpStatus.OK);
    }

    record NewCustomerRequest(
            String name,
            String email,
            Integer age
    ) {}

    @PostMapping("/addCustomer")
    public ResponseEntity<Customer> addCustomer(@RequestBody NewCustomerRequest request) {
        Customer customer = new Customer();
        customer.setAge(request.age);
        customer.setName(request.name);
        customer.setEmail(request.email);
        customerService.addCustomer(customer);
        return new ResponseEntity<>(customer,HttpStatus.CREATED);
    }

    @DeleteMapping("/deleteCustomers")
    public ResponseEntity<HttpStatus> deleteAllCustomers() {
        customerService.deleteAllCustomers();
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
