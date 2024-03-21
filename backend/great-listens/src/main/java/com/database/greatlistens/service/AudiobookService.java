package com.database.greatlistens.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.database.greatlistens.model.Audiobook;

@Service
public interface AudiobookService {
    List<Audiobook> getAllAudiobooks();
}
