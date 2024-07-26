package com.supportkim.kimchimall.order.infrastructure;

import com.supportkim.kimchimall.common.global.BaseEntity;
import com.supportkim.kimchimall.delivery.domain.Delivery;
import com.supportkim.kimchimall.delivery.infrastructure.DeliveryEntity;
import com.supportkim.kimchimall.member.infrastructure.MemberEntity;
import com.supportkim.kimchimall.orderkimchi.infrastructure.OrderKimchiEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

import static jakarta.persistence.CascadeType.*;
import static jakarta.persistence.FetchType.*;

@Entity
@Table(name = "orders")
@Getter @Builder
@AllArgsConstructor(access= AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class OrderEntity extends BaseEntity {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "orders_id")
    private Long id;

    @Enumerated
    private OrderStatus orderStatus;

    @OneToOne(fetch = LAZY)
    private DeliveryEntity delivery;

    @OneToMany(mappedBy = "order" , cascade = ALL)
    private List<OrderKimchiEntity> orderKimchis = new ArrayList<>();

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "member_id")
    private MemberEntity member;
}
