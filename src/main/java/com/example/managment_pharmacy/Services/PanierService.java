package com.example.managment_pharmacy.Services;


import com.example.managment_pharmacy.Entites.Panier;
import com.example.managment_pharmacy.Entites.PanierItem;
import com.example.managment_pharmacy.Entites.Produit;
import com.example.managment_pharmacy.Repositories.PanierRepository;
import com.example.managment_pharmacy.Repositories.ProduitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PanierService {
    @Autowired
    private ProduitRepository produitRepository;
    @Autowired
    private PanierRepository panierRepository;
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

}
