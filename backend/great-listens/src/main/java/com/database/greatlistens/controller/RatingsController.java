package com.database.greatlistens.controller;

import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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
    private static final Logger log = LoggerFactory.getLogger(RatingsController.class);

    @Autowired
    private RatingsService ratingsService;

    @PostMapping("/create")
    public ResponseEntity<String> createRating(@RequestHeader("Authorization") String token, @RequestBody Map<String, Object> requestBody) {
        log.debug("Received a request to create a rating with token: {}", token);

        // Attempt to retrieve mem_id and log the attempt
        Object memIdObj = requestBody.get("mem_id");
        log.debug("Retrieved mem_id from requestBody: {}", memIdObj);

        String memId;
        if (memIdObj instanceof String) {
            memId = (String) memIdObj;
        } else {
            log.error("mem_id is not of type String: {}", memIdObj);
            return ResponseEntity.badRequest().body("mem_id must be a string");
        }

        // Validate the token
        if (!TokenManager.validateToken(token, memId)) {
            log.error("Token validation failed for mem_id: {}", memId);
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid token");
        }

        // Parse bookId and rate, log if there's a type mismatch
        int bookId;
        int rate;
        try {
            bookId = (int) requestBody.get("book_id");
            rate = (int) requestBody.get("rate");
        } catch (ClassCastException e) {
            log.error("Failed to cast book_id or rate to int", e);
            return ResponseEntity.badRequest().body("book_id and rate must be integers");
        }

        // Log the values to be used in creating the rating
        log.debug("Creating rating with bookId: {}, memId: {}, rate: {}", bookId, memId, rate);

        // Create the rating
        try {
            ratingsService.createRating(bookId, memId, rate);
        } catch (Exception e) {
            log.error("Exception occurred when creating rating", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error creating rating");
        }

        log.debug("Rating created successfully for bookId: {}", bookId);
        return new ResponseEntity<>("Rating created successfully", HttpStatus.CREATED);
    }

    @GetMapping("/member")
    public ResponseEntity getAllRatingsMadeByMember(@RequestHeader("Authorization") String token, @RequestBody Map<String, Object> requestBody) {
        String memId = (String) requestBody.get("mem_id");
        if (!TokenManager.validateToken(token, memId)) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid token");
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