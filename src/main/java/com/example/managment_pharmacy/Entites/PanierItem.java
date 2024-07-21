package com.example.managment_pharmacy.Entites;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "cartItem")
public class PanierItem {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "produit_id")
    private Produit produit;


    @ManyToOne
    @JoinColumn(name = "panier_id")
    private Panier panier;

    private int quantity;
}
