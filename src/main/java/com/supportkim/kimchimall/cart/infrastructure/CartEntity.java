package com.supportkim.kimchimall.cart.infrastructure;

import jakarta.persistence.*;

@Entity
@Table(name = "carts")
public class CartEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cart_id")
    private Long id;
}
