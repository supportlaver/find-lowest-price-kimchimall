package com.supportkim.kimchimall.kimchi.infrastructure;


import com.supportkim.kimchimall.category.infrastructure.CategoryEntity;
import com.supportkim.kimchimall.common.global.BaseEntity;
import com.supportkim.kimchimall.kimchi.domain.Kimchi;
import com.supportkim.kimchimall.orderkimchi.infrastructure.OrderKimchiEntity;
import com.supportkim.kimchimall.review.infrastructure.ReviewEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

import static jakarta.persistence.CascadeType.*;
import static jakarta.persistence.FetchType.*;

@Entity
@Table(name = "kimchis")
@Getter @Builder
@AllArgsConstructor(access= AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class KimchiEntity extends BaseEntity {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "kimchi_id")
    private Long id;

    private String name;
    private int price;

    @OneToOne(fetch = LAZY)
    private CategoryEntity category;

    public static KimchiEntity from(Kimchi kimchi) {
        return KimchiEntity.builder()
                .id(kimchi.getId())
                .name(kimchi.getName())
                .category(kimchi.getCategory())
                .price(kimchi.getPrice())
                .build();
    }

    public Kimchi toModel() {
        return Kimchi.builder()
                .id(id)
                .category(category)
                .name(name)
                .price(price)
                .build();
    }
}
