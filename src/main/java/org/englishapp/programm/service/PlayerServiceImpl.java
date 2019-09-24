package org.englishapp.programm.service;

import org.englishapp.programm.repository.PlayerRepository;
import org.englishapp.programm.repository.WordRepository;
import org.springframework.stereotype.Service;

@Service
public class PlayerServiceImpl implements PlayerService {

    private PlayerRepository playerRepository;
    private WordRepository wordRepository;

    private WordService wordService;
    PlayerServiceImpl(PlayerRepository playerRepository, WordRepository wordRepository,WordService wordService){
        this.playerRepository = playerRepository;
        this.wordRepository = wordRepository;
        this.wordService = wordService;
    }


}
