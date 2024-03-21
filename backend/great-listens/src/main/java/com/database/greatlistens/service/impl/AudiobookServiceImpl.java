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
}
