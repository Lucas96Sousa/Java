package com.stellarviewer.proj.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.stellarviewer.proj.entities.Order;

public interface OrderRepository extends JpaRepository<Order,Long> {
    
}
