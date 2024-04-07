package com.database.greatlistens.repository;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.database.greatlistens.CompositeIds.AddedToId;
import com.database.greatlistens.model.AddedTo;
import com.database.greatlistens.model.Audiobook;

@Repository
public interface AddedToRepository extends JpaRepository<AddedTo, AddedToId> {
    // get all added to
    @Query(value = "SELECT * FROM added_to", nativeQuery=true)
    List<AddedTo> getAllBooksInCarts();

    // get count from added to
    @Query(value = "SELECT COUNT(*) FROM added_to", nativeQuery = true)
    int getCountAddedTo();

    // get by id
    @Query(value = "SELECT * FROM added_to WHERE book_id = :book_id AND cart_id = :cart_id", nativeQuery = true)
    AddedTo getAddedToById(@Param("cart_id") int cart_id, @Param("book_id") int book_id);

    // get books in cart
    @Query(value = "SELECT new com.database.greatlistens.model.Audiobook(a.book_id, a.book_name, a.book_author, a.book_narrator, a.categories, a.rating, a.price, a.listening_time) FROM Audiobook a JOIN AddedTo at ON a.book_id = at.book_id JOIN Cart c ON at.cart_id = c.cart_id WHERE c.cart_id = :cart_id")
    List<Audiobook> getBooksInCart(@Param("cart_id") int cart_id);

    // insert into added to
    @Modifying
    @Query(value = "INSERT INTO added_to (book_id, cart_id) VALUES (:book_id, :cart_id)", nativeQuery = true)
    void insertIntoAddedTo(@Param("cart_id") int cart_id, @Param("book_id") int book_id);

    // update added to
    @Query(value = "UPDATE added_to SET book_id = :new_book_id, cart_id = :new_cart_id WHERE book_id = :old_book_id AND cart_id = :old_cart_id", nativeQuery = true)
    void updateAddedTo(@Param("new_cart_id") int new_cart_id, @Param("new_book_id") int new_book_id, @Param("old_cart_id") int old_cart_id, @Param("old_book_id") int old_book_id);

    // delete from added to
    @Query(value = "DELETE FROM added_to WHERE book_id = :book_id AND cart_id = :cart_id", nativeQuery = true)
    void deleteFromAddedTo(@Param("cart_id") int cart_id, @Param("book_id") int book_id);
}
