package com.database.greatlistens.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.database.greatlistens.model.Audiobook;
import com.database.greatlistens.model.Cart;
import com.database.greatlistens.service.CartService;

@Controller
@RequestMapping("/api/cart")
public class CartController {

    @Autowired
    private CartService cartService;

    @PostMapping("/create")
    @ResponseBody
    public Cart createCart(@RequestBody Map<String, Object> requestBody) {
        String memId = (String) requestBody.get("mem_id");
        return cartService.createCart(memId);
    }

    @PutMapping("/add")
    @ResponseBody
    public ResponseEntity<String> addToCart(@RequestBody Map<String, Object> requestBody) {
        String memId = (String) requestBody.get("mem_id");
        Audiobook audiobook = mapToAudiobook(requestBody);
        Cart cart = mapToCart(requestBody);
        cartService.addToCart(memId, audiobook, cart);
        return ResponseEntity.ok("Added to cart successfully");
    }

    @GetMapping("/view")
    @ResponseBody
    public Cart viewCart(@RequestBody Map<String, Object> requestBody) {
        int cartId = (int) requestBody.get("cart_id");
        return cartService.viewCart(cartId);
    }

    @GetMapping("/books")
    @ResponseBody
    public List<Audiobook> getBooksInCart(@RequestBody Map<String, Object> requestBody) {
        int cartId = (int) requestBody.get("cart_id");
        return cartService.getBooksInCart(cartId);
    }

    @GetMapping("/total")
    @ResponseBody
    public double getCartTotal(@RequestBody Map<String, Object> requestBody) {
        int cartId = (int) requestBody.get("cart_id");
        return cartService.getCartTotal(cartId);
    }
    

    private Audiobook mapToAudiobook(Map<String, Object> requestBody) {
        Integer bookId = (Integer) requestBody.get("book_id");
        String bookName = (String) requestBody.get("book_name");
        String bookAuthor = (String) requestBody.get("book_author");
        String bookNarrator = (String) requestBody.get("book_narrator");
        String categories = (String) requestBody.get("categories");
        Double rating = (Double) requestBody.get("rating");
        Double price = (Double) requestBody.get("price");
        Integer listeningTime = (Integer) requestBody.get("listening_time");
    
        return new Audiobook(bookId, bookName, bookAuthor, bookNarrator, categories, rating, price, listeningTime);
    }
    
    private Cart mapToCart(Map<String, Object> requestBody) {
        Integer cartId = (Integer) requestBody.get("cart_id");
        String memId = (String) requestBody.get("mem_id");
        Double cartTotal = (Double) requestBody.get("cart_total");
    
        return new Cart(cartId, memId, cartTotal);
    }

}
