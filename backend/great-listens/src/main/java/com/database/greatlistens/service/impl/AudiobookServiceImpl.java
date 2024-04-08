package com.database.greatlistens.service.impl;

import com.database.greatlistens.model.Audiobook;
import com.database.greatlistens.repository.AudiobookRepository;
import com.database.greatlistens.service.AudiobookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AudiobookServiceImpl implements AudiobookService {
    @Autowired
    private AudiobookRepository audiobookRepository;

    public List<Audiobook> getAllAudiobooks() {
        return audiobookRepository.getAllAudiobooks(); 
    }

    public List<Audiobook> sortAudiobooksByPriceLowToHigh() {
        return audiobookRepository.sortAudiobooksByPriceLowToHigh();
    }

    public List<Audiobook> sortAudiobooksByPriceHighToLow() {
        return audiobookRepository.sortAudiobooksByPriceHighToLow();
    }

    public List<Audiobook> sortAudiobooksByListeningTimeLowToHigh() {
        return audiobookRepository.sortAudiobooksByListeningTimeLowToHigh();
    }

    public List<Audiobook> sortAudiobooksByListeningTimeHighToLow() {
        return audiobookRepository.sortAudiobooksByListeningTimeHighToLow();
    }

    public List<Audiobook> searchAudiobooksByAuthor(String author) {
        return audiobookRepository.searchAudiobooksByAuthor(author);
    }

    public List<Audiobook> searchAudiobooksByCategories(String categories) {
        return audiobookRepository.searchAudiobooksByCategories(categories);
    }

    public Audiobook searchByAudiobookId(Integer bookId) {
        return audiobookRepository.searchByAudiobookId(bookId);
    }

    public void updateAudiobook(int bookId, String newName, String newAuthor, String newNarrator,
                                String newCategories, double newRating, double newPrice, int newListeningTime) {
        audiobookRepository.updateAudiobook(bookId, newName, newAuthor, newNarrator,
                newCategories, newRating, newPrice, newListeningTime);
    }

    public void deleteAudiobookById(int bookId) {
        audiobookRepository.deleteAudiobookById(bookId);
    }
}
