package com.database.greatlistens.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.database.greatlistens.model.Audiobook;

@Repository
public interface AudiobookRepository extends JpaRepository<Audiobook, Integer> {
    @Query(value = "SELECT * FROM Audiobooks", nativeQuery = true)
    List<Audiobook> getAllAudiobooks();
}

