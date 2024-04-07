package com.database.greatlistens.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.database.greatlistens.CompositeIds.HasId;
import com.database.greatlistens.model.Has;

@Repository
public interface HasRepository extends JpaRepository<Has, HasId> {
    // get has count
    @Query(value = "SELECT COUNT(*) FROM has", nativeQuery = true)
    int getHasCount();

    // get all has
    @Query(value = "SELECT * FROM has", nativeQuery = true)
    List<Has> getAllHas();

    // get by id
    @Query(value = "SELECT * FROM has WHERE pay_id = :pay_id AND conf_code = :conf_code", nativeQuery = true)
    Has getHasById(@Param("pay_id") int pay_id, @Param("conf_code") int conf_code);

    // insert into has
    @Query(value = "INSERT INTO has (pay_id, conf_code) VALUES (:pay_id, :conf_code)", nativeQuery = true)
    void insertIntoHas(@Param("pay_id") int pay_id, @Param("conf_code") int conf_code);

    // update has
    @Query(value = "UPDATE has SET pay_id = :new_pay_id, conf_code = :new_conf_code WHERE pay_id = :old_pay_id AND conf_code = :old_conf_code", nativeQuery = true)
    void updateGoesTo(@Param("old_pay_id") int old_pay_id, @Param("old_conf_code") int old_conf_code, @Param("new_pay_id") int new_pay_id, @Param("new_conf_code") int new_conf_code);

    // delete from has
    @Query(value = "DELETE FROM has WHERE pay_id = :pay_id AND conf_code = :conf_code", nativeQuery = true)
    void deleteFromHas(@Param("pay_id") int pay_id, @Param("conf_code") int conf_code);
}
