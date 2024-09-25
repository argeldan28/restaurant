package com.example.restaurant.repository;

import com.example.restaurant.model.Role; // Importa correttamente la classe Role
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    // Metodo per trovare un ruolo per nome
    Optional<Role> findByName(String name);
}
