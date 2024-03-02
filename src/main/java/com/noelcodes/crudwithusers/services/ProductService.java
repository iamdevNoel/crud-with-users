package com.noelcodes.crudwithusers.services;

import com.noelcodes.crudwithusers.models.Product;
import com.noelcodes.crudwithusers.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public Product insert(Product product) {
        // Saves product to database, returns a copy of it for visualization
        return productRepository.save(product);
    }

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public Product findById(Long id) {
        // Repository's findById() returns an Optional object.
        // get() method converts it to the desirable type of object
        return productRepository.findById(id).get();
    }

    public Product update(Product newProduct, Long id) {
        Product product = productRepository.getReferenceById(id);
        updateData(product, newProduct);
        return productRepository.save(product);
    }

    // Auxiliary method for update() method
    // gives new product's data to a current product
    private void updateData(Product currentProduct, Product newProduct) {
        currentProduct.setQuantity(newProduct.getQuantity());
        currentProduct.setName(newProduct.getName());
        currentProduct.setPrice(newProduct.getPrice());
    }

    public void delete(Long id) {
        productRepository.deleteById(id);
    }
}
