/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.saraonval.webshop.controller.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

/**
 *
 * @author saraonva
 */
@Entity
@Data
@Table(name = "t_customer")
public class CustomerDTO {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
    private Integer id;
    
    @Column(name = "customer_email")
    private String email;
    
    @Column(name = "customer_password")
    private String password;
    
    @Column(name = "customer_first_name")
    private String firstName;
    
    @Column(name = "customer_last_name")
    private String lastName;
    
    @Column(name = "customer_date_of_birth")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date dateOfBirth;
    
    @Column(name = "customer_address")
    private String address;
    
    @Column(name = "customer_city")
    private String city;
    
    @Column(name = "customer_zip_code")
    private long zipCode;
    
    @Column(name = "customer_country")
    private String country;
    
}
