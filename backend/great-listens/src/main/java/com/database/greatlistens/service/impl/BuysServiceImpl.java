package com.database.greatlistens.service.impl;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.database.greatlistens.model.Confirmation;
import com.database.greatlistens.repository.BuysRepository;
import com.database.greatlistens.repository.ConfirmationRepository;
import com.database.greatlistens.repository.PaymentRepository;
import com.database.greatlistens.service.BuysService;

@Service
public class BuysServiceImpl implements BuysService{
    @Autowired
    private BuysRepository buysRepository;

    @Autowired
    private ConfirmationRepository confirmationRepository;

    @Autowired
    private PaymentRepository paymentRepository;

    @Transactional
    private int makePayment(String credit_card, String card_name, Date expiration, String csv) {
        int pay_id = paymentRepository.getPaymentCount();
        while (paymentRepository.paymentExists(pay_id) != 0) {
            pay_id +=1;
        }
        paymentRepository.insertIntoPayment(pay_id, credit_card, card_name, expiration, csv);
        return pay_id;
    }
    
    @Transactional
    private int createConfirmation(int pay_id, String card_holder) {
        int conf_code = confirmationRepository.getConfirmationCount();
        while (confirmationRepository.confirmationExists(conf_code) != 0) {
            conf_code +=1;
        }
        confirmationRepository.insertConfirmation(conf_code, pay_id, card_holder);
        return conf_code;
    }

    @Override
    @Transactional
    public Confirmation buyAudiobook(String mem_id, List<Integer> book_list, String card_holder, String credit_card, String card_name, Date expiration, String csv) {
        int pay_id = makePayment(credit_card, card_name, expiration, csv);
        int conf_code = createConfirmation(pay_id, card_holder);
        Confirmation confirmation = confirmationRepository.searchConfirmationById(conf_code);
        for (int book_id: book_list) {
            buysRepository.insertIntoBuys(book_id, mem_id);
        }
        return confirmation;
    }

}
