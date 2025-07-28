package com.ashiqulhoque.ecommerce_api.repository;

import com.ashiqulhoque.ecommerce_api.domain.Wishlist;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WishlistRepository extends JpaRepository<Wishlist, Long> {

    Wishlist findByCustIdAndRetiredDateIsNull(Long custId);
}
