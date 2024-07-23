package com.supportkim.kimchimall.review.infrastructure;

import jakarta.persistence.*;

@Entity
@Table(name = "revieews")
public class ReviewEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "reviews_id")
    private Long id;
}
