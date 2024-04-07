package com.database.greatlistens.repository;

import com.database.greatlistens.model.Payment;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Integer> {
    // get count of payments
    @Query(value = "SELECT COUNT(*) FROM payment", nativeQuery = true)
    int getPaymentCount();
    
    // get all payments
    @Query(value = "SELECT * FROM payment", nativeQuery = true)
    List<Payment> getAllPayments();

    // get payment by id
    @Query(value = "SELECT * FROM payment WHERE pay_id = :pay_id", nativeQuery = true)
    Payment getPaymentById(@Param("pay_id") int pay_id);
    
    // insert payment
    @Modifying
    @Query(value = "INSERT INTO payment (pay_id, credit_card, card_name, expiration, csv) VALUES (:pay_id, :credit_card, :card_name, :expiration, :csv)", nativeQuery = true)
    void insertIntoPayment(@Param("pay_id") int pay_id, @Param("credit_card") String credit_card, @Param("card_name") String card_name, @Param("expiration") Date expiration, @Param("csv") String csv);

    // update payment
    @Query(value = "UPDATE payment SET credit_card = :credit_card, card_name = :card_name, expiration = :expiration, csv = :csv WHERE pay_id = :pay_id", nativeQuery = true)
    void updatePayment(@Param("pay_id") int pay_id, @Param("credit_card") String credit_card, @Param("card_name") String card_name, @Param("expiration") Date expiration, @Param("csv") String csv);

    // delete payment
    @Query(value = "DELETE FROM payment WHERE pay_id = :pay_id", nativeQuery = true)
    void deletePayment(@Param("pay_id") int pay_id);
}
