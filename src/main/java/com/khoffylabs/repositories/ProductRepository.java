package com.khoffylabs.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.khoffylabs.entities.Product;

public interface ProductRepository extends JpaRepository<Product, String>{
    
}
