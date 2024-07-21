package com.example.managment_pharmacy.Repositories;

import com.example.managment_pharmacy.Entites.Panier;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PanierRepository extends JpaRepository<Panier,Long> {
    Optional<Panier> findById(Long aLong);
}
