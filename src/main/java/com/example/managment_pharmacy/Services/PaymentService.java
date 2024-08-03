package com.example.managment_pharmacy.Services;

import com.example.managment_pharmacy.DTO.PaymentDetailsDTO;
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
    public void processPayment(PaymentDetailsDTO paymentDetails) {
        Panier panier = panierRepository.findById(paymentDetails.getPanierId())
                .orElseThrow(() -> new RuntimeException("Panier not found"));

        double totalAmount = panier.getTotalPrice();

        // Implémentez la logique spécifique pour chaque mode de paiement
        switch (paymentDetails.getPaymentMethod()) {
            case PAYPAL:
                // Logic for PayPal payment
                // String paypalEmail = paymentDetails.getPaypalEmail(); // Removed
                break;
            case CREDIT_CARD:
                // Logic for credit card payment
                String creditCardNumber = paymentDetails.getCreditCardNumber();
                String securityCode = paymentDetails.getSecurityCode();
                String expirationDate = paymentDetails.getExpirationDate();
                // Validate and process credit card payment
                break;
            case DEBIT_CARD:
                // Logic for debit card payment
                // Similar to credit card processing
                break;
            case BANK_TRANSFER:
                // Logic for bank transfer payment
                break;
            case CASH:
                // Logic for cash payment
                break;
            default:
                throw new RuntimeException("Unsupported payment method");
        }

        panier.getItems().clear(); // Clear the panier items after payment
        panierRepository.save(panier);
    }
}
