package com.supportkim.kimchimall.cart.infrastructure;

import com.supportkim.kimchimall.cart.domain.Cart;
import com.supportkim.kimchimall.common.global.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "carts")
@Getter @Builder
@AllArgsConstructor(access= AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CartEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "cart_id")
    private Long id;

    // 카트(장바구니) 에 들어있는 수량
    private int quantity;

    public static CartEntity from(Cart cart) {
        return CartEntity.builder()
                .id(cart.getId())
                .quantity(cart.getQuantity())
                .build();
    }

    public Cart toModel() {
        return Cart.builder()
                .id(id)
                .quantity(quantity)
                .build();

    }


}
