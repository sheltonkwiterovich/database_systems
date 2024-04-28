package com.database.greatlistens.controller;

import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.database.greatlistens.Token.TokenManager;
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
    public ResponseEntity createCart(@RequestHeader("Authorization") String token, @RequestBody Map<String, Object> requestBody) {
        String memId = (String) requestBody.get("mem_id");
        if (!TokenManager.validateToken(token, memId)) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid token");
        }
        Cart cart = cartService.createCart(memId);
        return ResponseEntity.ok(cart);
    }

    @PutMapping("/add")
    @ResponseBody
    public ResponseEntity<String> addToCart(@RequestHeader("Authorization") String token, @RequestBody Map<String, Object> requestBody) {
        String memId = (String) requestBody.get("mem_id");
        
        
        if (!TokenManager.validateToken(token, memId)) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid token");
        }
        Audiobook audiobook = mapToAudiobook(requestBody);
        Cart cart = mapToCart(requestBody);
        cartService.addToCart(memId, audiobook, cart);
        return ResponseEntity.ok("Added to cart successfully");
    }

    @GetMapping("/view")
    @ResponseBody
    public ResponseEntity viewCart(@RequestHeader("Authorization") String token, @RequestBody Map<String, Object> requestBody) {
        String memId = (String) requestBody.get("mem_id");
        if (!TokenManager.validateToken(token, memId)) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid token");
        }
        int cartId = (int) requestBody.get("cart_id");
        Cart cart = cartService.viewCart(cartId);
        return ResponseEntity.ok(cart);
    }
    
    

    @GetMapping("/total")
    @ResponseBody
    public ResponseEntity getCartTotal(@RequestHeader("Authorization") String token, @RequestBody Map<String, Object> requestBody) {

        String memId = (String) requestBody.get("mem_id");
        int cartId = (int) requestBody.get("cart_id");
        if (!TokenManager.validateToken(token, memId)) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid token");
        }
        double total = cartService.getCartTotal(cartId);
        return ResponseEntity.ok(total);
    }

    private static final Logger log = LoggerFactory.getLogger(CartController.class);

    @GetMapping("/books")
    @ResponseBody
    public ResponseEntity getBooksInCart(@RequestHeader("Authorization") String token, @RequestBody Map<String, Object> requestBody) {
        int cartId = (int) requestBody.get("cart_id");
        if (token != null && token.startsWith("Bearer ")) {
            token = token.substring(7);
        }

        String memId = TokenManager.getTokenMemId(token);
        log.debug("Retrieved memId from token: {}", memId);

        if (memId == null || !TokenManager.validateToken(token, memId)) {
            log.warn("Token validation failed for memId: {}", memId);
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid token");
        }

        try {
            List<Audiobook> books = cartService.getBooksInCart(cartId);
            return ResponseEntity.ok(books);
        } catch (Exception e) {
            log.error("Error retrieving books from cart", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred while retrieving books from cart.");
        }
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
     
    @DeleteMapping("/removeBook")
    public ResponseEntity<String> removeBookFromCart(@RequestHeader("Authorization") String token, @RequestBody Map<String, Object> requestBody) {
        String memId = (String) requestBody.get("mem_id");
        if (!TokenManager.validateToken(token, memId)) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid token");
        }
        Integer cartId = (Integer) requestBody.get("cart_id");
        Integer bookId = (Integer) requestBody.get("book_id");
        cartService.removeBookFromCart(cartId, bookId);
        return ResponseEntity.ok("Book removed from cart successfully.");
    }


}