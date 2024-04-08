package com.database.greatlistens.controller;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.database.greatlistens.model.Audiobook;
import com.database.greatlistens.service.AudiobookService;

@Controller
@RequestMapping("/api/audiobooks")
public class AudiobookController {

    @Autowired
    private AudiobookService audiobookService;

    // http://localhost:8080/api/audiobooks
    @GetMapping
    @ResponseBody
    public List<Audiobook> getAllAudiobooks() {
        return audiobookService.getAllAudiobooks();
    }

    // http://localhost:8080/api/audiobooks/sort/price/low-to-high
    @GetMapping("/sort/price/low-to-high")
    @ResponseBody
    public List<Audiobook> sortAudiobooksByPriceLowToHigh() {
        return audiobookService.sortAudiobooksByPriceLowToHigh();
    }

    // http://localhost:8080/api/audiobooks/sort/price/high-to-low
    @GetMapping("/sort/price/high-to-low")
    @ResponseBody
    public List<Audiobook> sortAudiobooksByPriceHighToLow() {
        return audiobookService.sortAudiobooksByPriceHighToLow();
    }
    // http://localhost:8080/api/audiobooks/sort/listening-time/low-to-high
    @GetMapping("/sort/listening-time/low-to-high")
    @ResponseBody
    public List<Audiobook> sortAudiobooksByListeningTimeLowToHigh() {
        return audiobookService.sortAudiobooksByListeningTimeLowToHigh();
    }

    // http://localhost:8080/api/audiobooks/sort/listening-time/high-to-low

    @GetMapping("/sort/listening-time/high-to-low")
    @ResponseBody
    public List<Audiobook> sortAudiobooksByListeningTimeHighToLow() {
        return audiobookService.sortAudiobooksByListeningTimeHighToLow();
    }

    // http://localhost:8080/api/audiobooks/search/author
    @GetMapping("/search/author")
    @ResponseBody
    public List<Audiobook> searchAudiobooksByAuthor(@RequestBody Map<String, Object> requestBody) {
        String author = (String) requestBody.get("author");
        return audiobookService.searchAudiobooksByAuthor(author);
    }

    // http://localhost:8080/api/audiobooks/search/categories––
    @GetMapping("/search/categories")
    @ResponseBody
    public List<Audiobook> searchAudiobooksByCategories(@RequestBody Map<String, Object> requestBody) {
        String categories = (String) requestBody.get("categories");
        return audiobookService.searchAudiobooksByCategories(categories);
    }

    // http://localhost:8080/api/audiobooks/search/id/{bookId}
    @GetMapping("/search/id/{bookId}")
    @ResponseBody
    public Audiobook searchByAudiobookId(@PathVariable Integer bookId) {
        return audiobookService.searchByAudiobookId(bookId);
    }

    @PutMapping("/update")
    public ResponseEntity<String> updateAudiobook(@RequestBody Map<String, Object> requestBody) {
        int bookId = (int) requestBody.get("bookId");
        String bookName = (String) requestBody.get("bookName");
        String bookAuthor = (String) requestBody.get("bookAuthor");
        String bookNarrator = (String) requestBody.get("bookNarrator");
        String categories = (String) requestBody.get("categories");
        Double rating = (Double) requestBody.get("rating");
        Double price = (Double) requestBody.get("price");
        Integer listeningTime = (Integer) requestBody.get("listeningTime");
    
        audiobookService.updateAudiobook(bookId, bookName, bookAuthor, bookNarrator,
                categories, rating, price, listeningTime);
    
        return ResponseEntity.ok("Audiobook updated successfully");
    }
}
