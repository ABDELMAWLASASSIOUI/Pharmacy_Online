package com.example.managment_pharmacy.Controllers;

import com.example.managment_pharmacy.Entites.Panier;
import com.example.managment_pharmacy.Entites.PanierAddResquest;
import com.example.managment_pharmacy.Services.PanierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.logging.Logger;

@RestController
@RequestMapping("/api")
public class PanierController {
    @Autowired
    private PanierService panierService;
    /*
    @PostMapping("/addItem")
    public ResponseEntity<Panier> addItemToPanier(@RequestBody PanierAddResquest request) {
        Panier panier = panierService.addItemToPanier(request.getPanierId(), request.getProduitId(), request.getQuantity());
        if (panier != null) {
            return ResponseEntity.ok(panier);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

     */

    @PostMapping("/addItem")
    public ResponseEntity<String> addItemToPanier(@RequestBody PanierAddResquest request) {
        Panier panier = panierService.addItemToPanier(request.getPanierId(), request.getProduitId(), request.getQuantity());
        if (panier != null) {
            return ResponseEntity.ok("L'article a été ajouté au panier avec succès.");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Le panier ou le produit n'a pas été trouvé.");
        }
    }
    @PostMapping
    public ResponseEntity<Panier> createPanier(@RequestBody Panier panier) {
        Panier createdPanier = panierService.createPanier(panier);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdPanier);
    }

    /*
    @DeleteMapping("/removeItem/{itemId}")
    public Panier removeItemFromPanier(@PathVariable Long itemId) {
        return panierService.removeItemById(itemId);
    }

     */
    @DeleteMapping("/removeItem/{itemId}")
    public ResponseEntity<String> removeItemFromPanier(@PathVariable Long itemId) {
        try {
            Panier panier = panierService.removeItemById(itemId);
            return ResponseEntity.ok("L'article a été supprimé du panier avec succès.");
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
    private static final Logger logger = Logger.getLogger(PanierController.class.getName());

    @GetMapping("/{id}/total")
    public ResponseEntity<Double> getTotalPrice(@PathVariable Long id) {
        logger.info("Calculating total price for Panier ID " + id);
        double totalPrice = panierService.calculerTotalPrixPanier(id);
        logger.info("Total price for Panier ID " + id + " is " + totalPrice);
        return ResponseEntity.ok(totalPrice);
    }
/*
    @DeleteMapping("/deleteItem")
    public ResponseEntity<Panier> removeItemFromPanier(@RequestBody PanierAddResquest panierAddResquest) {
        Panier updatedPanier = panierService.removeItemFromPanier(panierAddResquest.getPanierId(), panierAddResquest.getProduitId());
        return updatedPanier != null ? ResponseEntity.ok(updatedPanier) : ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

 */
    /*
    @GetMapping("/totalPrice/{panierId}")
    public ResponseEntity<Double> getTotalPrice(@PathVariable Long panierId) {
        Double totalPrice = panierService.calculateTotalPrice(panierId);
        return totalPrice != null ? ResponseEntity.ok(totalPrice) : ResponseEntity.notFound().build();
    }


     */
}
