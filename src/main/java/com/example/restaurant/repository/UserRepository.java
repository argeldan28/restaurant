package com.example.restaurant.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.restaurant.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    // Metodo per trovare un utente per username
    Optional<User> findByUsername(String username);
    
    // Metodo per verificare se un username esiste già
    boolean existsByUsername(String username);

    // Metodo per trovare un utente per email
    Optional<User> findByEmail(String email);
}
