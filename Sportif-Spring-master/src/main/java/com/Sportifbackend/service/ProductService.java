package com.Sportifbackend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Sportifbackend.exceptions.ProductNotFoundException;
import com.Sportifbackend.exceptions.UserNotFoundException;
import com.Sportifbackend.model.Product;
import com.Sportifbackend.repo.ProductRepository;

import java.util.List;

@Service
public class ProductService {
	@Autowired
    private final ProductRepository repo;

    public ProductService(ProductRepository repo) {
        this.repo = repo;
    }

    public List<Product> getProducts () {
        return repo.findAll();
    }

    public Product getProduct (Long id) {
        return repo.findById(id).orElseThrow(() ->
                new ProductNotFoundException("Product by id " + id + " was not found."));
    }

    public Product addProduct (Product product) {
        return repo.save(product);
    }

    public Product updateProduct (Long id, Product product) {
        Product oldProduct = getProduct(id);

        oldProduct.setName(product.getName());
        oldProduct.setDescription(product.getDescription());
        oldProduct.setPrice(product.getPrice());
        oldProduct.setImage(product.getImage());

        return repo.save(oldProduct);
    }

    public void deleteProduct (Long id) {
        repo.deleteById(id);
    }
}
