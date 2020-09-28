/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.saraonval.webshop.service;

import com.github.saraonval.webshop.controller.model.CustomerDTO;
import com.github.saraonval.webshop.repository.CustomerRepository;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author saraonva
 */
@Service
public class CustomerService {
    
    private CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }
    
    public CustomerDTO getCustomer(Integer id) {
        return customerRepository.findById(id).orElse(null);
    }

    public CustomerDTO postCustomer(CustomerDTO customerDTO) {
        return customerRepository.save(customerDTO);
    }

    public CustomerDTO putCustomer(CustomerDTO customerDTO, Integer id) {
        return customerRepository.findById(id)
            .map(customer -> {

                customer.setPassword(customerDTO.getPassword());
                customer.setEmail(customerDTO.getEmail());

                customer.setFirstName(customerDTO.getFirstName());
                customer.setLastName(customerDTO.getLastName());
                customer.setDateOfBirth(customerDTO.getDateOfBirth());

                customer.setAddress(customerDTO.getAddress());
                customer.setCity(customerDTO.getCity());
                customer.setZipCode(customerDTO.getZipCode());
                customer.setCountry(customerDTO.getCountry());

                return customerRepository.save(customer);
            })
            .orElseGet(() -> {
                customerDTO.setId(id);
                return customerRepository.save(customerDTO);
            });
    }

    public void deleteCustomer(Integer id) {
        customerRepository.deleteById(id);
    }

    public List<CustomerDTO> getCustomers() {
        return customerRepository.findAll();
    }
    
}
