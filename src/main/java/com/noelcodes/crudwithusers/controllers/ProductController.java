package com.noelcodes.crudwithusers.controllers;

import com.noelcodes.crudwithusers.models.Product;
import com.noelcodes.crudwithusers.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    @PostMapping
    public ResponseEntity<Product> insert(@RequestBody Product product) {
        // Saves given product to database, and keeps it to be returned at response body
        Product newProduct = productService.insert(product);

        // Http Status 201 (Created)
        return ResponseEntity.status(HttpStatus.CREATED).body(newProduct);
    }

    @GetMapping
    public ResponseEntity<List<Product>> findAll() {
        List<Product> products = productService.findAll();
        return ResponseEntity.ok().body(products);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Product> findById(@PathVariable Long id) {
        Product productFound = productService.findById(id);
        return ResponseEntity.ok().body(productFound);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Product> update(@RequestBody Product newProduct, @PathVariable Long id) {
        Product updatedProduct = productService.update(newProduct, id);
        return ResponseEntity.ok().body(updatedProduct);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        productService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
