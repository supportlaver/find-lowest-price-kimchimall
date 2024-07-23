package com.supportkim.kimchimall.orderkimchi.infrastructure;

import jakarta.persistence.*;

@Entity
@Table(name = "order_kimchis")
public class OrderKimchiEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_kimchi_id")
    private Long id;
}
