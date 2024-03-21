package com.database.greatlistens.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.database.greatlistens.model.Audiobook;
import com.database.greatlistens.repository.AudiobookRepository;

@Controller
@RequestMapping("/api")
public class AudiobookController {

    private final AudiobookRepository audiobookRepository;

    @Autowired
    public AudiobookController(AudiobookRepository audiobookRepository) {
        this.audiobookRepository = audiobookRepository;
    }

    @GetMapping("/audiobooks")
    public ResponseEntity<List<Audiobook>> getAllAudiobooks() {
        List<Audiobook> audiobooks = audiobookRepository.findAll();
        return ResponseEntity.ok().body(audiobooks);
    }
}
