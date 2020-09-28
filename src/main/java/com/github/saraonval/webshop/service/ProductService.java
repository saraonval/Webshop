/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.saraonval.webshop.service;

import com.github.saraonval.webshop.controller.model.ProductDTO;
import com.github.saraonval.webshop.repository.ProductRepository;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author saraonva
 */
@Service
public class ProductService {
    
    private ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public ProductDTO getProduct(Integer id) {
        return productRepository.findById(id).orElse(null);
    }

    public List<ProductDTO> getProducts() {
        return productRepository.findAll();
    }

    public ProductDTO postProduct(ProductDTO productDTO) {
        return productRepository.save(productDTO);
    }

    public ProductDTO putProduct(ProductDTO productDTO, Integer id) {
        return productRepository.findById(id)
            .map(product -> {
                product.setName(productDTO.getName());
                product.setBrand(productDTO.getBrand());
                product.setPrice(productDTO.getPrice());
                product.setDescription(productDTO.getDescription());
                product.setImageURL(productDTO.getImageURL());
                product.setCategory(productDTO.getCategory());
                product.setStockQuantity(productDTO.getStockQuantity());
                return productRepository.save(product);
            })
            .orElseGet(() -> {
                productDTO.setId(id);
                return productRepository.save(productDTO);
            });
    }

    public void deleteProduct(Integer id) {
        productRepository.deleteById(id);
    }
    
}
