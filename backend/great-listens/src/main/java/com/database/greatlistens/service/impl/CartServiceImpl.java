package com.database.greatlistens.service.impl;

import java.util.List;


import org.springframework.transaction.annotation.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.database.greatlistens.model.Audiobook;
import com.database.greatlistens.model.Cart;
import com.database.greatlistens.repository.AddedToRepository;
import com.database.greatlistens.repository.CartRepository;
import com.database.greatlistens.service.CartService;

@Service
public class CartServiceImpl implements CartService{
    @Autowired
    private CartRepository cartRepository;
    @Autowired
    private AddedToRepository addedToRepository;

    @Override
    @Transactional
    public Cart createCart(String mem_id) {
        int cart_id = cartRepository.getCartCount();
        System.out.println("!!!!!!!!!!!!!!!!!!!!\n");
        System.out.println(cart_id);
        System.out.println("!!!!!!!!!!!!!!!!!!!!\n");
        cartRepository.createCart(cart_id, mem_id, 0.0);
        System.out.println("TEST\n");
        Cart cart = cartRepository.searchByCartId(cart_id);
        return cart;
    }

    @Override
    @Transactional
    public void addToCart(String mem_id, Audiobook audiobook, Cart cart) {
        double audiobookPrice = audiobook.getPrice();
        double curCartTotal = cart.getCart_total();
        double updatedCartTotal = audiobookPrice + curCartTotal;
        int cart_id = cart.getCart_id();
        cartRepository.updateCartTotal(cart_id, updatedCartTotal);
        int book_id = audiobook.getBook_id();
        addedToRepository.insertIntoAddedTo(cart_id, book_id);
    }

    @Override
    public Cart viewCart(int cart_id) {
        Cart cart = cartRepository.searchByCartId(cart_id);
        return cart;
    }

    @Override
    public List<Audiobook> getBooksInCart(int cart_id) {
        List<Audiobook> booksInCart = addedToRepository.getBooksInCart(cart_id);
        return booksInCart;
    }

    @Override
    public double getCartTotal(int cart_id) {
        double cartTotal = cartRepository.getCartTotal(cart_id);
        return cartTotal;
    }

}
