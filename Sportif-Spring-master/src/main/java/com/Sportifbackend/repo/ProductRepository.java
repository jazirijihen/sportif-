package com.Sportifbackend.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Sportifbackend.model.Product;
import com.Sportifbackend.model.User;

import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {
    void deleteById(Long id);
    Optional<Product> findById (Long id);
}
