/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.saraonval.webshop.controller;

import com.github.saraonval.webshop.controller.model.CustomerDTO;
import com.github.saraonval.webshop.service.CustomerService;
import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author saraonva
 */
@RestController
@RequestMapping("/customer")
public class CustomerController {
    
    private CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }
    
    @GetMapping("/{id}")
    public CustomerDTO getCustomer(@PathVariable Integer id) {
        return customerService.getCustomer(id);
    }
    
    @PostMapping
    public CustomerDTO postCustomer(@RequestBody CustomerDTO customerDTO) {
        return customerService.postCustomer(customerDTO);
    }
    
    @PutMapping("/{id}")
    public CustomerDTO putCustomer(@RequestBody CustomerDTO customerDTO, 
            @PathVariable Integer id) {
        return customerService.putCustomer(customerDTO, id);
    }
    
    @DeleteMapping("/{id}")
    public void deleteCustomer(@PathVariable Integer id) {
        customerService.deleteCustomer(id);
    }
    
    @GetMapping
    public List<CustomerDTO> getCustomers() {
        return customerService.getCustomers();
    }
    
}
