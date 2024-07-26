package com.supportkim.kimchimall.cart.service.port;

import com.supportkim.kimchimall.cart.domain.Cart;

public interface CartRepository {

    Cart save(Cart cart);
}
