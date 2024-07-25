package com.supportkim.kimchimall.review.infrastructure;

import com.supportkim.kimchimall.common.global.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "reviews")
@Getter @Builder
@AllArgsConstructor(access= AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ReviewEntity extends BaseEntity {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "reviews_id")
    private Long id;

    private String comment;
    private int score;
}
