/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.saraonval.webshop.controller;

import com.github.saraonval.webshop.controller.model.ProductDTO;
import com.github.saraonval.webshop.service.ProductService;
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
@RequestMapping("/product")
public class ProductController {
    
    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }
    
    @GetMapping("/{id}")
    public ProductDTO getProduct(@PathVariable Integer id) {
        return productService.getProduct(id);
    }
    
    @GetMapping
    public List<ProductDTO> getProducts() {
        return productService.getProducts();
    }
    
    @PostMapping
    public ProductDTO postProduct(@RequestBody ProductDTO productDTO) {
        return productService.postProduct(productDTO);
    }
    
    @PutMapping("/{id}")
    public ProductDTO putProduct(@RequestBody ProductDTO productDTO,
            @PathVariable Integer id) {
        return productService.putProduct(productDTO, id);
    }
    
    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Integer id) {
        productService.deleteProduct(id);
    }
    
}
