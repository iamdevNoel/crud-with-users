package com.noelcodes.crudwithusers.repositories;

import com.noelcodes.crudwithusers.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
