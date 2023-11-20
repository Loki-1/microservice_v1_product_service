package com.dailycodebuffer.productservice.repository;

import com.dailycodebuffer.productservice.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
