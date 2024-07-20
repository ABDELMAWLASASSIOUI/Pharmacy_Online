package com.example.managment_pharmacy.Repositories;

import com.example.managment_pharmacy.Entites.Produit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProduitRepository extends JpaRepository<Produit,Long> {
}
