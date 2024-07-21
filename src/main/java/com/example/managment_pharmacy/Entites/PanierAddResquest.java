package com.example.managment_pharmacy.Entites;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PanierAddResquest {

    private Long id;
    private Long produitId;
    private int quantity;
}
