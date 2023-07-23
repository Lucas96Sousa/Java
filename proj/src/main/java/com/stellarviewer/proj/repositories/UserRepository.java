package com.stellarviewer.proj.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.stellarviewer.proj.entities.User;

public interface UserRepository extends JpaRepository<User,Long> {
    
}
