package com.example.managment_pharmacy.Entites;

import com.fasterxml.jackson.annotation.JsonBackReference;
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
    @JsonBackReference//add last
    private Produit produit;


    @ManyToOne
    @JoinColumn(name = "panier_id")
    @JsonBackReference//add last
    private Panier panier;

    private int quantity;
}
