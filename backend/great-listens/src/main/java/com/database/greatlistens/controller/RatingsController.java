package com.database.greatlistens.controller;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.database.greatlistens.Token.TokenManager;
import com.database.greatlistens.model.Ratings;
import com.database.greatlistens.service.RatingsService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;


@Controller
@RequestMapping("/api/ratings")
public class RatingsController {
    @Autowired
    private RatingsService ratingsService;

    @PostMapping("/create")
    public ResponseEntity<String> createRating(@RequestHeader("Authorization") String token, @RequestBody Map<String, Object> requestBody) {
        Object memIdObj = requestBody.get("mem_id");
        String memId;
        if (memIdObj instanceof String) {
            memId = (String) memIdObj;
        } else {
            return ResponseEntity.badRequest().body("mem_id must be a string");
        }
        if (!TokenManager.validateToken(token, memId)) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid token");
        }
        int bookId;
        int rate;
        try {
            bookId = (int) requestBody.get("book_id");
            rate = (int) requestBody.get("rate");
        } catch (ClassCastException e) {
            return ResponseEntity.badRequest().body("book_id and rate must be integers");
        }
        try {
            ratingsService.createRating(bookId, memId, rate);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error creating rating");
        }
        return new ResponseEntity<>("Rating created successfully", HttpStatus.CREATED);
    }

    @GetMapping("/member")
    @ResponseBody
    public ResponseEntity<List<Ratings>> getAllRatingsMadeByMember(@RequestHeader("Authorization") String token, @RequestParam("mem_id") String memId) {
        if (!TokenManager.validateToken(token, memId)) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
        List<Ratings> ratings = ratingsService.getAllRatingsMadeByMember(memId);
        return new ResponseEntity<>(ratings, HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<String> updateRatings(@RequestHeader("Authorization") String token, @RequestBody Map<String, Object> requestBody) {
        String memId = (String) requestBody.get("mem_id");
        if (!TokenManager.validateToken(token, memId)) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid token");
        }
        int bookId = (int) requestBody.get("book_id");
        int rate = (int) requestBody.get("rate");
        ratingsService.updateRatings(bookId, memId, rate);
        return new ResponseEntity<>("Rating updated successfully", HttpStatus.OK);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteRating(@RequestHeader("Authorization") String token, @RequestBody Map<String, Object> requestBody) {
        String memId = (String) requestBody.get("mem_id");
        if (!TokenManager.validateToken(token, memId)) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid token");
        }
        int bookId = (int) requestBody.get("book_id");
        ratingsService.deleteRating(bookId, memId);
        return new ResponseEntity<>("Rating deleted successfully", HttpStatus.OK);
    }
}