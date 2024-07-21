package com.example.managment_pharmacy.Entites;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "cart")
public class Panier {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "panier",cascade = CascadeType.ALL)
    @JsonManagedReference//add last
    private List<PanierItem> items;
/*
    @OneToMany(mappedBy = "panier")
    private List<Produit> produits;

 */
}
