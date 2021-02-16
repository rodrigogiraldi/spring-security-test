package com.example.springsecuritytest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springsecuritytest.model.Product;
import com.example.springsecuritytest.service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {
	
	@Autowired
	private ProductService productService;

	@PreAuthorize("hasRole('USER')")
	@GetMapping("/")
	public List<Product> list(){
		return productService.list();
	}
	
	@PreAuthorize("hasRole('USER')")
	@GetMapping("/{id}")
	public Product get(@PathVariable("id") Long id){
		return productService.get(id);
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	@PostMapping("/")
	public Product create(@RequestBody Product product) {
		return productService.create(product);
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	@PutMapping("/{id}")
	public void update(@PathVariable("id") Long id, @RequestBody Product product){
		productService.update(id, product);
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	@DeleteMapping("/{id}")
	public void delete(@PathVariable("id") Long id){
		productService.delete(id);
	}
}
