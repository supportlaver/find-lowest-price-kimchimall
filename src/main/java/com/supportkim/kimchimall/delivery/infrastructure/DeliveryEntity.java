package com.supportkim.kimchimall.delivery.infrastructure;

import com.supportkim.kimchimall.common.global.BaseEntity;
import com.supportkim.kimchimall.member.infrastructure.Address;
import jakarta.persistence.*;
import lombok.*;

import static jakarta.persistence.EnumType.*;

@Entity
@Table(name = "deliveries")
@Getter @Builder
@AllArgsConstructor(access= AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class DeliveryEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "delivery_id")
    private Long id;

    @Embedded
    private Address address;

    @Enumerated(value = STRING)
    private DeliveryStatus deliveryStatus;
}
