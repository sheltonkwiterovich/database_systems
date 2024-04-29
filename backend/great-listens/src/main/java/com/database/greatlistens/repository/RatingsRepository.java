package com.database.greatlistens.repository;

import com.database.greatlistens.model.Ratings;
import com.database.greatlistens.CompositeIds.RatingsId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface RatingsRepository extends JpaRepository<Ratings, RatingsId> {
    // get ratings count
    @Query(value = "SELECT COUNT(*) FROM ratings", nativeQuery = true)
    int getRatingsCount();

    // get all ratings
    @Query(value = "SELECT * FROM ratings", nativeQuery = true)
    List<Ratings> getAllRatings();

    // get rating by id
    @Query(value = "SELECT * FROM ratings WHERE book_id = :book_id AND mem_id = :mem_id", nativeQuery = true)
    Ratings getRatingsById(@Param("book_id") int book_id, @Param("mem_id") String mem_id);

    // get rating by member
    @Query(value = "SELECT * FROM ratings WHERE mem_id = :mem_id", nativeQuery = true)
    List<Ratings> getRatingsByMember(@Param("mem_id") String mem_id);

    // insert into ratings
    @Query(value = "INSERT INTO ratings (book_id, mem_id, rate) VALUES (:book_id, :mem_id, :rate)", nativeQuery = true)
    @Modifying
    void insertIntoRatings(@Param("book_id") int book_id, @Param("mem_id") String mem_id, @Param("rate") int rate);

    // update rating
    @Query(value = "UPDATE ratings SET book_id = :new_book_id, mem_id = :new_mem_id, rate = :new_rate WHERE book_id = :old_book_id AND mem_id = :old_mem_id", nativeQuery = true)
    @Modifying
    void updateRatings(@Param("new_book_id") int new_book_id, @Param("new_mem_id") String new_mem_id, @Param("new_rate") int new_rate, @Param("old_book_id") int old_book_id, @Param("old_mem_id") String old_mem_id);

    // delete rating
    @Query(value = "DELETE FROM ratings WHERE book_id = :book_id AND mem_id = :mem_id", nativeQuery = true)
    @Modifying
    void deleteRating(@Param("book_id") int book_id, @Param("mem_id") String mem_id);    
}
