package com.example.demo.service;

import com.example.demo.model.Product;
import com.example.demo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    public Set<Product> findAll(){
        Set<Product> products = new HashSet<>();
        for (Product product: productRepository.findAll()) {
            products.add(product);
        }
        return products;
    }

    public Optional<Product> findProduct(long id){
        return productRepository.findById(id);
    }

    public void deleteProduct(Product product){
        productRepository.delete(product);
    }
}
