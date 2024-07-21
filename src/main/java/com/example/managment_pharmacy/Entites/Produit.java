package com.example.managment_pharmacy.Entites;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

<<<<<<< HEAD
import java.util.List;

=======
import java.util.Set;
>>>>>>> 1c21c04f5295479d10d84a1a6506fc5c782c24b4

@Getter
@Setter
@Entity
@Table(name = "produits")
public class Produit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private double price;

    @Column(nullable = false)
    private int quantity;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "categorie_id", nullable = false)
    @JsonBackReference
    private Categorie categorie;
    /*
    @ManyToOne
    @JoinColumn(name = "panier_id")
    private Panier panier;

     */
   /* @OneToMany(mappedBy = "produit",cascade = CascadeType.ALL)
    private Set<PanierItem> itemSet;

    */
<<<<<<< HEAD
    @OneToMany(mappedBy = "produit")
    private List<PanierItem> cartItems;
=======
>>>>>>> 1c21c04f5295479d10d84a1a6506fc5c782c24b4

}
