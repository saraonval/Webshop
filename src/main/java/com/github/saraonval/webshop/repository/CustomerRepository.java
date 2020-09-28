/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.saraonval.webshop.repository;

import com.github.saraonval.webshop.controller.model.CustomerDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author saraonva
 */
@Repository
public interface CustomerRepository extends JpaRepository<CustomerDTO, Integer>{
}
