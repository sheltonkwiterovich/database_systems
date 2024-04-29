package com.database.greatlistens.controller;

import java.sql.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.database.greatlistens.model.Confirmation;
import com.database.greatlistens.service.BuysService;

@Controller
@RequestMapping("/api/buy")
public class BuysController {

    @Autowired
    private BuysService buysService;
    
    @PostMapping
    @ResponseBody
    public Confirmation buyAudiobooks(@RequestBody Map<String, Object> requestBody) {
        String memId = (String) requestBody.get("mem_id");
        List<Integer> bookList = (List<Integer>) requestBody.get("book_list");
        String cardHolder = (String) requestBody.get("card_holder");
        String creditCard = (String) requestBody.get("credit_card");
        String cardName = (String) requestBody.get("card_name");
        Date expiration = Date.valueOf((String) requestBody.get("expiration"));
        String csv = (String) requestBody.get("csv");
        return buysService.buyAudiobook(memId, bookList, cardHolder, creditCard, cardName, expiration, csv);
    }
}