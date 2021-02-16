package com.example.springsecuritytest.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.springsecuritytest.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
