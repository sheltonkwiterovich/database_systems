package com.database.greatlistens.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.database.greatlistens.model.Ratings;
import com.database.greatlistens.repository.RatingsRepository;
import com.database.greatlistens.service.RatingsService;

@Service
public class RatingsServiceImpl implements RatingsService{
    @Autowired
    private RatingsRepository ratingsRepository;

    @Override
    @Transactional
    public void createRating(int book_id, String mem_id, int rate) {
        ratingsRepository.insertIntoRatings(book_id, mem_id, rate);
    }

    @Override
    public List<Ratings> getAllRatingsMadeByMember(String mem_id) {
        return ratingsRepository.getRatingsByMember(mem_id);
    }

    @Override
    @Transactional
    public void updateRatings(int book_id, String mem_id, int rate) {
        ratingsRepository.updateRatings(book_id, mem_id, rate, book_id, mem_id);
    }

    @Override
    @Transactional
    public void deleteRating(int book_id, String mem_id) {
        ratingsRepository.deleteRating(book_id, mem_id);
    }

}
