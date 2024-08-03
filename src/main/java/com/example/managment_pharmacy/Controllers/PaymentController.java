package com.example.managment_pharmacy.Controllers;

import com.example.managment_pharmacy.DTO.PaymentDetailsDTO;
import com.example.managment_pharmacy.Services.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @PostMapping("/payment")
    public String processPayment(@RequestBody PaymentDetailsDTO paymentDetails) {
        paymentService.processPayment(paymentDetails);
        return "Payment successful for panier ID: " + paymentDetails.getPanierId() +
                " using " + paymentDetails.getPaymentMethod();
    }
}


