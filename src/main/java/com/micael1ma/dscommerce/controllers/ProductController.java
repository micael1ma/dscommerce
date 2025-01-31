package com.micael1ma.dscommerce.controllers;

import com.micael1ma.dscommerce.dto.ProductDTO;
import com.micael1ma.dscommerce.entities.Product;
import com.micael1ma.dscommerce.repositories.ProductRepository;
import com.micael1ma.dscommerce.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping(value = "/products")
public class ProductController {

    @Autowired
    private ProductService service;

    @GetMapping(value = "/{id}")
    public ProductDTO findByid(@PathVariable Long id) {
        return service.findById(id);
    }
}
