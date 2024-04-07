package com.database.greatlistens.repository;

import com.database.greatlistens.model.Confirmation;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ConfirmationRepository extends JpaRepository<Confirmation, Integer> {
    // get count of confirmations
    @Query(value = "SELECT COUNT(*) FROM confirmation", nativeQuery = true)
    int getConfirmationCount();

    // get all confirmations
    @Query(value = "SELECT * FROM confirmation", nativeQuery = true)
    List<Confirmation> getAllConfirmations();
    // search by id
    @Query(value = "SELECT * FROM confirmation c WHERE c.conf_code = :conf_code", nativeQuery = true)
    Confirmation searchConfirmationById(@Param("conf_code") int conf_code);

    // insert confirmation
    @Modifying
    @Query(value = "INSERT INTO confirmation (conf_code, pay_id, card_holder) VALUES (:conf_code, :pay_id, :card_holder)", nativeQuery = true)
    void insertConfirmation(@Param("conf_code") int conf_code, @Param("pay_id") int pay_id, @Param("card_holder") String card_holder);

    // update confirmation
    @Modifying
    @Query(value = "UPDATE confirmation SET pay_id = :pay_id, card_holder = :card_holder WHERE conf_code = :conf_code", nativeQuery = true)
    void updateConfirmation(@Param("conf_code") int conf_code, @Param("pay_id") int pay_id, @Param("card_holder") String card_holder);

    // delete confiration
    @Query(value = "DELETE FROM confirmation WHERE conf_code = :conf_code", nativeQuery = true)
    void deleteConfirmation(@Param("conf_code") int conf_code);
}

