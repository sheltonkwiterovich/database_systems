package com.database.greatlistens.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.database.greatlistens.model.Ratings;

@Service
public interface RatingsService {
    public void createRating(int book_id, String mem_id, int rate);
    public List<Ratings> getAllRatingsMadeByMember(String mem_id);
    public void updateRatings(int book_id, String mem_id, int rate);
    public void deleteRating(int book_id, String mem_id);

}
