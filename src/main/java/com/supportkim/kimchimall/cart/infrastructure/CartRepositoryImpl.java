package com.supportkim.kimchimall.cart.infrastructure;

import com.supportkim.kimchimall.cart.domain.Cart;
import com.supportkim.kimchimall.cart.service.port.CartRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class CartRepositoryImpl implements CartRepository {
    private final CartJpaRepository cartJpaRepository;
    @Override
    public Cart save(Cart cart) {
        return cartJpaRepository.save(CartEntity.from(cart)).toModel();
    }
}
