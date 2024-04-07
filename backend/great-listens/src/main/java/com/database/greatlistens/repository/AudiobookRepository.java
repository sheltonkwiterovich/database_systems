package com.database.greatlistens.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.database.greatlistens.model.Audiobook;

@Repository
public interface AudiobookRepository extends JpaRepository<Audiobook, Integer> {
    // get count of audiobooks
    @Query(value = "SELECT COUNT(*) FROM audiobook", nativeQuery = true)
    int getAudiobookCount();
    
    // get all audiobooks
    @Query(value = "SELECT * FROM audiobook", nativeQuery = true)
    List<Audiobook> getAllAudiobooks();

    // sort by price - low to high
    @Query(value = "SELECT * FROM audiobook ORDER BY price ASC", nativeQuery = true)
    List<Audiobook> sortAudiobooksByPriceLowToHigh();

    // sort by price - high to low
    @Query(value = "SELECT * FROM audiobook ORDER BY price DESC", nativeQuery = true)
    List<Audiobook> sortAudiobooksByPriceHighToLow();

    // sort by listening time - low to high
    @Query(value = "SELECT * FROM audiobook ORDER BY listening_time ASC", nativeQuery = true)
    List<Audiobook> sortAudiobooksByListeningTimeLowToHigh();

    // sort by listening time - high to low
    @Query(value = "SELECT * FROM audiobook ORDER BY listening_time DESC", nativeQuery = true)
    List<Audiobook> sortAudiobooksByListeningTimeHighToLow();
    
    // sort by rating - low to high
    @Query(value = "SELECT * FROM audiobook ORDER BY rating ASC", nativeQuery = true)
    List<Audiobook> sortAudiobooksByRatingLowToHigh();

    // sort by rating - high to low
    @Query(value = "SELECT * FROM audiobook ORDER BY rating DESC", nativeQuery = true)
    List<Audiobook> sortAudiobooksByRatingHighToLow();

    // search by author
    @Query(value = "SELECT * FROM audiobook a WHERE a.book_author = :author", nativeQuery = true)
    List<Audiobook> searchAudiobooksByAuthor(@Param("author") String author);

    // search by narrator
    @Query(value = "SELECT * FROM audiobook a WHERE a.book_narrator = :narrator", nativeQuery = true)
    List<Audiobook> searchAudiobooksByNarrator(@Param("narrator") String narrator);

    // search by category
    @Query(value = "SELECT * FROM audiobook a WHERE a.categories = :categories", nativeQuery = true)
    List<Audiobook> searchAudiobooksByCategories(@Param("categories") String categories);
    
    // search by id
    @Query(value = "SELECT * FROM audiobook a WHERE a.book_id = :bookId", nativeQuery = true)
    Audiobook searchByAudiobookId(@Param("bookId") Integer bookId);

    // insert into audiobook
    @Query(value = "INSERT INTO audiobook (book_id, book_name, book_author, book_narrator, categories, rating, price, listening_time) VALUES(:book_id, :book_name, :book_author, :book_narrator, :categories, :rating,:price, :listening_time", nativeQuery = true)
    void insertIntoAudiobook(@Param("book_id") int book_id, @Param("book_name") String book_name,
    @Param("book_author") String book_author, @Param("book_narrator") String book_narrator,
    @Param("categories") String categories, @Param("rating") double rating,
    @Param("price") double price, @Param("listening_time") int listening_time);
    
    // update audiobook
    @Modifying
    @Query(value = "UPDATE audiobook a SET a.book_name = :newName, a.book_author = :newAuthor, " +
    "a.book_narrator = :newNarrator, a.categories = :newCategories, " +
    "a.rating = :newRating, a.price = :newPrice, a.listening_time = :newListeningTime " +
    "WHERE a.book_id = :bookId", nativeQuery = true)
    @Transactional
    void updateAudiobook(@Param("bookId") int bookId, @Param("newName") String newName,
              @Param("newAuthor") String newAuthor, @Param("newNarrator") String newNarrator,
              @Param("newCategories") String newCategories, @Param("newRating") double newRating,
              @Param("newPrice") double newPrice, @Param("newListeningTime") int newListeningTime);

    // delete audiobook
    @Query(value = "DELETE FROM audiobook a WHERE a.book_id = :bookId", nativeQuery = true)
    void deleteAudiobookById(@Param("bookId") int bookId);

}

