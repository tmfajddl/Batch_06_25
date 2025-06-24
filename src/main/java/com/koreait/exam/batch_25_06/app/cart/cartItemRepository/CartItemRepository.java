package com.koreait.exam.batch_25_06.app.cart.cartItemRepository;

import com.koreait.exam.batch_25_06.app.cart.entity.CartItem;
import com.koreait.exam.batch_25_06.app.entity.BaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Objects;
import java.util.Optional;

public interface CartItemRepository extends JpaRepository<CartItem, Long> {


    Optional<CartItem> findByMemberIdAndProductOptionId(Long memberId, Long productOptionId);
}
