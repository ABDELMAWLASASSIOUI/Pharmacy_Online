package com.example.managment_pharmacy.DTO;

import com.example.managment_pharmacy.Entites.PaymentMethod;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class PaymentDetailsDTO {
    // Getters and setters
    private Long panierId;
    private PaymentMethod paymentMethod;
    private String creditCardNumber;
    private String securityCode;
    private String expirationDate; // Add expiration date field

}
