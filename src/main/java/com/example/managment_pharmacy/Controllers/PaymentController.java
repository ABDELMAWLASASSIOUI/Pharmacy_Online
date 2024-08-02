package com.example.managment_pharmacy.Controllers;
import com.example.managment_pharmacy.Services.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/payment")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @PostMapping("/{panierId}")
    public String processPayment(@PathVariable Long panierId) {
        paymentService.processPayment(panierId);
        return "Payment successful for panier ID: " + panierId;
    }
}

