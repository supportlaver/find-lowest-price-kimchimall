package com.supportkim.kimchimall.orderkimchi.infrastructure;

import com.supportkim.kimchimall.common.global.BaseEntity;
import com.supportkim.kimchimall.kimchi.domain.Kimchi;
import com.supportkim.kimchimall.kimchi.infrastructure.KimchiEntity;
import com.supportkim.kimchimall.order.infrastructure.OrderEntity;
import jakarta.persistence.*;
import lombok.*;

import static jakarta.persistence.FetchType.*;

@Entity
@Table(name = "order_kimchis")
@Getter @Builder
@AllArgsConstructor(access= AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class OrderKimchiEntity extends BaseEntity {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "order_kimchi_id")
    private Long id;

    private int orderPrice;
    private int quantity;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "orders_id")
    private OrderEntity order;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "kimchi_id")
    private KimchiEntity kimchi;

}
