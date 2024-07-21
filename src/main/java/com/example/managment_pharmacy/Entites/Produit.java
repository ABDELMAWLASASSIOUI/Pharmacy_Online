package com.example.managment_pharmacy.Entites;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

<<<<<<< HEAD
import java.util.Set;

=======
>>>>>>> 054545baf9b609b6c3502655cfc84ab77bd45379
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
<<<<<<< HEAD
   /* @OneToMany(mappedBy = "produit",cascade = CascadeType.ALL)
    private Set<PanierItem> itemSet;

    */
=======
>>>>>>> 054545baf9b609b6c3502655cfc84ab77bd45379
}
