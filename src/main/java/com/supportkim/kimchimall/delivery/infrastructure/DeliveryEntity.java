package com.supportkim.kimchimall.delivery.infrastructure;

import jakarta.persistence.*;

@Entity
@Table(name = "deliveries")
public class DeliveryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "delivery_id")
    private Long id;
}
