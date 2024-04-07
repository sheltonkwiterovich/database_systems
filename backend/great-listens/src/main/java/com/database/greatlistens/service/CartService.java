package com.database.greatlistens.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.database.greatlistens.model.Audiobook;
import com.database.greatlistens.model.Cart;

@Service
public interface CartService {
    Cart createCart(String mem_id);
    void addToCart(String mem_id, Audiobook audiobook, Cart cart);
    Cart viewCart(int cart_id);
    List<Audiobook> getBooksInCart(int cart_id);
    double getCartTotal(int cart_id);
}
