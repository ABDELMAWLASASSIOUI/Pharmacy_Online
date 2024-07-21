package com.example.managment_pharmacy.Services;


import com.example.managment_pharmacy.Entites.Panier;
import com.example.managment_pharmacy.Entites.PanierItem;
import com.example.managment_pharmacy.Entites.Produit;
import com.example.managment_pharmacy.Repositories.PanierItemRepository;
import com.example.managment_pharmacy.Repositories.PanierRepository;
import com.example.managment_pharmacy.Repositories.ProduitRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.logging.Logger;

@Service
public class PanierService {
    @Autowired
    private ProduitRepository produitRepository;
    @Autowired
    private PanierRepository panierRepository;
    @Autowired
    private PanierItemRepository panierItemRepository;
    public Panier addItemToPanier(Long panierId, Long produitId, int quantity) {
        if (panierId == null || produitId == null) {
            throw new IllegalArgumentException("The given id must not be null");
        }

        Optional<Panier> optionalPannier = panierRepository.findById(panierId);
        Optional<Produit> optionalProduct = produitRepository.findById(produitId);

        if (optionalPannier.isPresent() && optionalProduct.isPresent()) {
            Panier panier = optionalPannier.get();
            Produit produit = optionalProduct.get();

            PanierItem item = new PanierItem();
            item.setProduit(produit);
            item.setPanier(panier);
            item.setQuantity(quantity);

            panier.getItems().add(item);

            return panierRepository.save(panier);
        }

        return null;
    }
    public Panier createPanier(Panier panier) {
        return panierRepository.save(panier);
    }

//remove Item
@Transactional
public Panier removeItemById(Long itemId) {
    Optional<PanierItem> optionalItem = panierItemRepository.findById(itemId);
    if (optionalItem.isPresent()) {
        PanierItem itemToRemove = optionalItem.get();
        Panier panier = itemToRemove.getPanier(); // Récupère le panier associé

        panier.getItems().remove(itemToRemove); // Supprime l'élément du panier
        panierItemRepository.deleteById(itemId); // Supprime l'élément de la base de données
        panierRepository.save(panier); // Met à jour le panier

        return panier;
    } else {
        throw new RuntimeException("Article non trouvé");
    }

}

    private static final Logger logger = Logger.getLogger(PanierService.class.getName());

    public double calculerTotalPrixPanier(Long panierId) {
        Optional<Panier> optionalPanier = panierRepository.findById(panierId);
        if (optionalPanier.isPresent()) {
            Panier panier = optionalPanier.get();
            double totalPrice = panier.getTotalPrice();
            logger.info("Total price for Panier ID " + panierId + " is " + totalPrice);
            return totalPrice;
        } else {
            logger.warning("Panier ID " + panierId + " not found.");
            return 0.0;
        }
    }
    /*
    public Panier removeItemFromPanier(Long panierId, Long produitId) {
        Optional<Panier> optionalPanier = panierRepository.findById(panierId);
        if (optionalPanier.isPresent()) {
            Panier panier = optionalPanier.get();
            PanierItem itemToRemove = null;

            for (PanierItem item : panier.getItems()) {
                if (item.getProduit().getId().equals(produitId)) {
                    itemToRemove = item;
                    break;
                }
            }

            if (itemToRemove != null) {
                panier.getItems().remove(itemToRemove);
                return panierRepository.save(panier);
            }
        }

        return null;
    }

     */
    /*

    public Double calculateTotalPrice(Long panierId) {
        Panier panier = panierRepository.findById(panierId).orElse(null);
        if (panier == null) {
            return null;
        }

        double totalPrice = 0;
        for (Produit produit : panier.getProduits()) {
            totalPrice += produit.getPrice() * produit.getQuantity();
        }

        return totalPrice;
    }

     */

}
