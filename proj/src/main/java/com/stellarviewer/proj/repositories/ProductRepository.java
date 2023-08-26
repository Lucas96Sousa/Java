package com.stellarviewer.proj.repositories;
import org.springframework.data.jpa.repository.JpaRepository;

import com.stellarviewer.proj.entities.Product;


public interface ProductRepository extends JpaRepository<Product, Long> {
    
}
