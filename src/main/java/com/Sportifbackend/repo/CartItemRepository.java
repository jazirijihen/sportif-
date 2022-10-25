package com.Sportifbackend.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.Sportifbackend.model.cart.CartItem;
import com.Sportifbackend.model.cart.CartItemPK;

public interface CartItemRepository extends JpaRepository <CartItem, CartItemPK> {
}
