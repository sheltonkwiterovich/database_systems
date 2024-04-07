package com.database.greatlistens.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.database.greatlistens.CompositeIds.GoesToId;
import com.database.greatlistens.model.Goes_To;

@Repository
public interface GoesToRepository extends JpaRepository<Goes_To, GoesToId> {
    // get goes to count
    @Query(value = "SELECT COUNT(*) FROM goes_to", nativeQuery = true)
    int getGoesToCount();

    // get all goes_to
    @Query(value = "SELECT * FROM goes_to", nativeQuery = true)
    List<Goes_To> getAllGoesTo();

    // get by id
    @Query(value = "SELECT * FROM goes_to WHERE cart_id = :cart_id AND pay_id = :pay_id", nativeQuery = true)
    Goes_To getGoesToById(@Param("cart_id") int cart_id, @Param("pay_id") int pay_id);

    // insert into goes to
    @Query(value = "INSERT INTO goes_to (cart_id, pay_id) VALUES (:cart_id, :pay_id)", nativeQuery = true)
    void insertIntoGoesTo(@Param("cart_id") int cart_id, @Param("pay_id") int pay_id);

    // update goes to
    @Query(value = "UPDATE goes_to SET cart_id = :new_cart_id, pay_id = :new_pay_id WHERE cart_id = :old_cart_id AND pay_id = :old_pay_id", nativeQuery = true)
    void updateGoesTo(@Param("old_cart_id") int old_cart_id, @Param("old_pay_id") int old_pay_id, @Param("new_cart_id") int new_cart_id, @Param("new_pay_id") int new_pay_id);

    // delete from goes to
    @Query(value = "DELETE FROM goes_to WHERE cart_id = :cart_id AND pay_id = :pay_id", nativeQuery = true)
    void deleteFromGoesTo(@Param("cart_id") int cart_id, @Param("pay_id") int pay_id);
}
