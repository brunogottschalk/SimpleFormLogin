package com.login.form.configurations.services;

import java.util.List;

import com.login.form.models.Product;
import com.login.form.repositories.ProductRepository;

import org.springframework.stereotype.Service;

@Service
public class ProductService {

  private final ProductRepository productRepository;

  public ProductService(ProductRepository productRepository) {
    this.productRepository = productRepository;
  }

  public List<Product> findAll() {
    return productRepository.findAll();
  }

}
