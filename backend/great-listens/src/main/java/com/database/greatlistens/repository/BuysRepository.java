package com.database.greatlistens.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.database.greatlistens.CompositeIds.BuysId;
import com.database.greatlistens.model.Buys;

@Repository
public interface BuysRepository extends JpaRepository<Buys, BuysId> {
    // get count of buys
    @Query(value =  "SELECT COUNT(*) FROM buys", nativeQuery = true)
    int getCountBuys();

    // get all from buys
    @Query(value = "SELECT * FROM buys", nativeQuery = true)
    List<Buys> getAllBoughtsBought();

    // get by id
    @Query(value = "SELECT * FROM buys WHERE book_id = :book_id AND mem_id = :mem_id", nativeQuery = true)
    Buys getBookBoughtById(@Param("book_id") int book_id, @Param("mem_id") String mem_id);

    // insert into buys
    @Modifying
    @Query(value = "INSERT INTO buys (mem_id, book_id) VALUES (:mem_id, :book_id)", nativeQuery = true)
    void insertIntoBuys(@Param("book_id") int book_id, @Param("mem_id") String mem_id);

    // update buys
    @Query(value = "UPDATE buys SET mem_id = :new_mem_id, book_id = :new_book_id WHERE mem_id = :old_mem_id AND book_id = :old_book_id", nativeQuery = true)
    void updateBuys(@Param("new_book_id") int new_book_id, @Param("new_mem_id") String new_mem_id, @Param("old_book_id") int old_book_id, @Param("old_mem_id") String old_mem_id);

    // delete from buys
    @Query(value = "DELETE FROM buys WHERE mem_id = :mem_id AND book_id = :book_id", nativeQuery = true)
    void deleteFromBuys(@Param("book_id") int book_id, @Param("mem_id") String mem_id);

    @Query(value = "SELECT * FROM buys WHERE mem_id = :mem_id", nativeQuery = true)
    List<Buys> getBooksBoughtByMember(@Param("mem_id") String mem_id);
}
