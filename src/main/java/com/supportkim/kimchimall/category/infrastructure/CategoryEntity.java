package com.supportkim.kimchimall.category.infrastructure;

import com.supportkim.kimchimall.common.global.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

import static jakarta.persistence.EnumType.*;

@Entity
@Table(name = "categories")
@Getter @Builder
@AllArgsConstructor(access= AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CategoryEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "category_id")
    private Long id;

    @Enumerated(value = STRING)
    private CategoryType name;
}
