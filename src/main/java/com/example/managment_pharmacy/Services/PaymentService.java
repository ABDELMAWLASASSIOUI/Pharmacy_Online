package com.example.managment_pharmacy.Services;

import com.example.managment_pharmacy.Entites.Panier;
import com.example.managment_pharmacy.Repositories.PanierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PaymentService {

    @Autowired
    private PanierRepository panierRepository;

    @Transactional
    public void processPayment(Long panierId) {
        Panier panier = panierRepository.findById(panierId)
                .orElseThrow(() -> new RuntimeException("Panier not found"));

        double totalAmount = panier.getTotalPrice();
        panier.getItems().clear();// Clear the panier items after payment
        panierRepository.save(panier);
    }
}
