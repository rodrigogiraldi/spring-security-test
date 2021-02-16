package com.example.springsecuritytest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springsecuritytest.model.Product;
import com.example.springsecuritytest.persistence.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;

	public List<Product> list() {
		return productRepository.findAll();
	}

	public Product get(Long id) {
		return productRepository.findById(id).orElse(null);
	}

	public Product create(Product product) {
		return productRepository.save(product);
	}

	public void update(Long id, Product product) {
		productRepository.findById(id).ifPresent(p -> {
			p.setName(product.getName());
			p.setDescription(product.getDescription());
			productRepository.save(p);
		});
	}

	public void delete(Long id) {
		productRepository.deleteById(id);
	}
}
