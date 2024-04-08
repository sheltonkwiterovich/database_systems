package com.database.greatlistens.service;

import java.sql.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.database.greatlistens.model.Confirmation;

@Service
public interface BuysService {
    Confirmation buyAudiobook(String mem_id, List<Integer> book_list, String card_holder, String credit_card, String card_name, Date expiration, String csv);
    
}
