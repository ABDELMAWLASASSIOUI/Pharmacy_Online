package com.example.managment_pharmacy.Controllers;

import com.example.managment_pharmacy.Entites.Produit;
import com.example.managment_pharmacy.Services.ProduitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/produits")
public class ProduitController {
    @Autowired
    private ProduitService produitService;
    @PostMapping
    public ResponseEntity<Produit> createProduit(@RequestBody Produit produit) {
        Produit createdProduit = produitService.createProduit(produit);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdProduit);
    }
    @GetMapping
    public ResponseEntity<List<Produit>> getAllProduits() {
        List<Produit> produits = produitService.getAllProduits();
        return ResponseEntity.ok(produits);
    }
    @GetMapping("/{id}")
        public Optional<Produit> getProduitById(@PathVariable Long id){
         return produitService.getProduitById(id);
        }

        @DeleteMapping("/{id}")
       public ResponseEntity<Void> deleteProduitById(@PathVariable Long id){
         produitService.deleteProduit(id);
            return ResponseEntity.noContent().build();
        }

    @PutMapping("/{id}")
    public ResponseEntity<Produit> updateProduit(@PathVariable Long id, @RequestBody Produit produit) {
        Produit updatedProduit = produitService.updateProduit(id, produit);
        return updatedProduit != null ? ResponseEntity.ok(updatedProduit) : ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }




}
