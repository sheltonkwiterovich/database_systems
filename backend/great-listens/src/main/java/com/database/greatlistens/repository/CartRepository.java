package com.database.greatlistens.repository;

import com.database.greatlistens.model.Cart;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepository extends JpaRepository<Cart, Integer> {
    // get count of cart
    @Query(value = "SELECT COUNT(*) FROM cart", nativeQuery = true)
    int getCartCount();
    
    // get all carts
    @Query(value = "SELECT * FROM cart", nativeQuery = true)
    List<Cart> getAllCarts();

    // search by id
    @Query(value = "SELECT * FROM cart c WHERE c.cart_id = :cart_id", nativeQuery = true)
    Cart searchByCartId(@Param("cart_id") Integer cart_id);

    // insert
    @Modifying
    @Query(value = "INSERT INTO cart(cart_id, mem_id, cart_total) VALUES(:cart_id, :mem_id, :cart_total)", nativeQuery = true)
    void createCart(@Param("cart_id") Integer cart_id, @Param("mem_id") String mem_id, @Param("cart_total") double cart_total);

    // update
    @Modifying
    @Query(value = "UPDATE cart SET mem_id = :mem_id, cart_total = :cart_total WHERE cart_id = :cart_id", nativeQuery = true)
    void updateCart(@Param("cart_id") Integer cart_id, @Param("mem_id") String mem_id, @Param("cart_total") double cart_total);

    @Modifying
    @Query(value = "UPDATE cart SET cart_total = :cart_total WHERE cart_id = :cart_id", nativeQuery = true)
    void updateCartTotal(@Param("cart_id") Integer cart_id, @Param("cart_total") double cart_total);
    // delete
    @Query(value = "DELETE FROM cart WHERE cart_id = :cart_id", nativeQuery = true)
    Cart deleteByCartId(@Param("cart_id") Integer cart_id);

    // get cart_total
    @Query(value = "SELECT cart_total FROM cart where cart_id = :cart_id", nativeQuery = true)
    double getCartTotal(@Param("cart_id") int cart_id);

    @Query(value = "SELECT COUNT(*) AS cart_count FROM cart WHERE cart_id = :cart_id", nativeQuery = true)
    int cartExists(@Param("cart_id") int cart_id); 
}

