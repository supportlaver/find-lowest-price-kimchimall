package com.supportkim.kimchimall.kimchi.infrastructure;


import jakarta.persistence.*;

@Entity
@Table(name = "kimchis")
public class KimchiEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "kimchi_id")
    private Long id;
}
