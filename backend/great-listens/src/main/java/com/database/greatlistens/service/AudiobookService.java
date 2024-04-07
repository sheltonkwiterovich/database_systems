package com.database.greatlistens.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.database.greatlistens.model.Audiobook;

@Service
public interface AudiobookService {
    List<Audiobook> getAllAudiobooks();

    List<Audiobook> sortAudiobooksByPriceLowToHigh();

    List<Audiobook> sortAudiobooksByPriceHighToLow();

    List<Audiobook> sortAudiobooksByListeningTimeLowToHigh();

    List<Audiobook> sortAudiobooksByListeningTimeHighToLow();

    List<Audiobook> searchAudiobooksByAuthor(String author);

    List<Audiobook> searchAudiobooksByCategories(String categories);

    Audiobook searchByAudiobookId(Integer bookId);

    void updateAudiobook(int bookId, String newName, String newAuthor, String newNarrator,
                         String newCategories, double newRating, double newPrice, int newListeningTime);

    void deleteAudiobookById(int bookId);
}
