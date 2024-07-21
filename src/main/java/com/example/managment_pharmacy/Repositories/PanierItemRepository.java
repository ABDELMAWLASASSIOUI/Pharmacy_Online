package com.example.managment_pharmacy.Repositories;

import com.example.managment_pharmacy.Entites.PanierItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PanierItemRepository extends JpaRepository<PanierItem,Long> {
}
