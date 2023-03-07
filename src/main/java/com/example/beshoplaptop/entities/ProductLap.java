package com.example.beshoplaptop.entities;


import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "Product")
public class ProductLap {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name_product")
    private String nameProduct;
    @Column(name = "type_product")
    private String typeProduct;
    @Column(name = "color_product")
    private  String colosProduct;
    @Column(name = "money_product")
    private  Integer moneyProduct;
    
}
