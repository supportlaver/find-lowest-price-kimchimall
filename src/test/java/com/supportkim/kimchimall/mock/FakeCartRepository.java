package com.supportkim.kimchimall.mock;

import com.supportkim.kimchimall.cart.domain.Cart;
import com.supportkim.kimchimall.cart.service.port.CartRepository;
import com.supportkim.kimchimall.member.domain.Member;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * In-memory Repository
 */
public class FakeCartRepository implements CartRepository {
    private static Long id = 0L;
    private final List<Cart> data = new ArrayList<>();

    @Override
    public Cart save(Cart cart) {
        if (cart.getId() == null) {
            Cart newCart = Cart.builder()
                    .id(id++)
                    .quantity(cart.getQuantity())
                    .build();
            data.add(newCart);
            return newCart;
        } else {
            // 기존에 있던 것을 삭제
            data.removeIf(c -> Objects.equals(c.getId() , cart.getId()));
            data.add(cart);
            return cart;
        }
    }
}
