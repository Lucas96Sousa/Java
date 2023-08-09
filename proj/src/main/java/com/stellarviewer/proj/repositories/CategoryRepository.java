package com.stellarviewer.proj.repositories;
import org.springframework.data.jpa.repository.JpaRepository;

import com.stellarviewer.proj.entities.Category;


public interface CategoryRepository extends JpaRepository<Category, Long> {
    
}
