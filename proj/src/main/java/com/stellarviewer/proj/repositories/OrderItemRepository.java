package com.stellarviewer.proj.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.stellarviewer.proj.entities.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {

}
