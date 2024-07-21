package com.example.managment_pharmacy.Controllers;

import com.example.managment_pharmacy.Entites.Panier;
import com.example.managment_pharmacy.Entites.PanierAddResquest;
import com.example.managment_pharmacy.Services.PanierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class PanierController {
    @Autowired
    private PanierService panierService;
    @PostMapping("/items/add")
    public ResponseEntity<Panier> addItemToPannier(@RequestBody PanierAddResquest panierAddResquest) {
        Panier updatedPanier = panierService.addItemToPanier(panierAddResquest.getId(), panierAddResquest.getProduitId(), panierAddResquest.getQuantity());
        return updatedPanier != null ? ResponseEntity.ok(updatedPanier) : ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
    @PostMapping
    public ResponseEntity<Panier> createPanier(@RequestBody Panier panier) {
        Panier createdPanier = panierService.createPanier(panier);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdPanier);
    }
}
