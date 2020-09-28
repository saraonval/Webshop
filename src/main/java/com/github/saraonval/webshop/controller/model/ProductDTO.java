/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.saraonval.webshop.controller.model;

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
@Table(name = "t_product")
public class ProductDTO {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Integer id;
    
    @Column(name = "product_name")
    private String name;
    
    @Column(name = "product_brand")
    private String brand;
    
    @Column(name = "product_price")
    private float price;
    
    @Column(name = "product_description")
    private String description;
    
    @Column(name = "product_image_url")
    private String imageURL;
    
    @Column(name = "product_category")
    private String category;
    
    @Column(name = "product_stock_quantity")
    private int stockQuantity;
}
