package com.paymentchain.customer.controller;

import com.paymentchain.customer.entities.Customer;
import com.paymentchain.customer.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerRestController {

    @Autowired
    CustomerRepository customerRepository;


    @GetMapping("/list")
    public  ResponseEntity<List<Customer>> findAll(){

        List<Customer> customerList = customerRepository.findAll();
        return new ResponseEntity<>(customerList, HttpStatus.OK);
    }


    @PostMapping("/create")
    public ResponseEntity<Customer> post(@RequestBody Customer customer){
        Customer customerSaved = customerRepository.save(customer);
        return new ResponseEntity<>(customerSaved, HttpStatus.CREATED);
    }

}