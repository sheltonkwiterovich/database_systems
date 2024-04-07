package com.database.greatlistens.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.database.greatlistens.model.Ratings;
import com.database.greatlistens.service.RatingsService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@Controller
@RequestMapping("/api/ratings")
public class RatingsController {

    @Autowired
    private RatingsService ratingsService;

    @PostMapping("/create")
    public ResponseEntity<String> createRating(@RequestBody Map<String, Object> requestBody) {
        int bookId = (int) requestBody.get("book_id");
        String memId = (String) requestBody.get("mem_id");
        int rate = (int) requestBody.get("rate");
        ratingsService.createRating(bookId, memId, rate);
        return new ResponseEntity<>("Rating created successfully", HttpStatus.CREATED);
    }

    @GetMapping("/member")
    public ResponseEntity<List<Ratings>> getAllRatingsMadeByMember(@RequestBody Map<String, Object> requestBody) {
        String memId = (String) requestBody.get("mem_id");
        List<Ratings> ratings = ratingsService.getAllRatingsMadeByMember(memId);
        return new ResponseEntity<>(ratings, HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<String> updateRatings(@RequestBody Map<String, Object> requestBody) {
        int bookId = (int) requestBody.get("book_id");
        String memId = (String) requestBody.get("mem_id");
        int rate = (int) requestBody.get("rate");
        ratingsService.updateRatings(bookId, memId, rate);
        return new ResponseEntity<>("Rating updated successfully", HttpStatus.OK);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteRating(@RequestBody Map<String, Object> requestBody) {
        int bookId = (int) requestBody.get("book_id");
        String memId = (String) requestBody.get("mem_id");
        ratingsService.deleteRating(bookId, memId);
        return new ResponseEntity<>("Rating deleted successfully", HttpStatus.OK);
    }
    



}
