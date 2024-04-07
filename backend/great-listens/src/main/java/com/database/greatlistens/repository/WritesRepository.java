package com.database.greatlistens.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.database.greatlistens.CompositeIds.WritesId;
import com.database.greatlistens.model.Writes;

@Repository
public interface WritesRepository extends JpaRepository<Writes, WritesId> {
    // get count of writes
    @Query(value =  "SELECT COUNT(*) FROM writes", nativeQuery = true)
    int getCountWrites();

    // get all from writes
    @Query(value = "SELECT * FROM writes", nativeQuery = true)
    List<Writes> getAllWrites();

    // get by id
    @Query(value = "SELECT * FROM writes WHERE book_id = :book_id AND mem_id = :mem_id", nativeQuery = true)
    Writes getWritesById(@Param("book_id") int book_id, @Param("mem_id") String mem_id);

    // insert into writes
    @Query(value = "INSERT INTO writes (mem_id, book_id) VALUES (:mem_id, :book_id)", nativeQuery = true)
    void insertIntoWrites(@Param("book_id") int book_id, @Param("mem_id") String mem_id);

    // update writes
    @Query(value = "UPDATE writes SET mem_id = :new_mem_id, book_id = :new_book_id WHERE mem_id = :old_mem_id AND book_id = :old_book_id", nativeQuery = true)
    void updateWrites(@Param("new_book_id") int new_book_id, @Param("new_mem_id") String new_mem_id, @Param("old_book_id") int old_book_id, @Param("old_mem_id") String old_mem_id);

    // delete from writes
    @Query(value = "DELETE FROM writes WHERE mem_id = :mem_id AND book_id = :book_id", nativeQuery = true)
    void deleteFromBuys(@Param("book_id") int book_id, @Param("mem_id") String mem_id);


}