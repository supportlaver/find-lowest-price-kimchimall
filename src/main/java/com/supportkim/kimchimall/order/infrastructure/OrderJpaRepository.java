package com.supportkim.kimchimall.order.infrastructure;

import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderJpaRepository extends JpaRepository<OrderEntity , Long> {
}
