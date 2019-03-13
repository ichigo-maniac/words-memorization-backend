package com.words.memorization.words.service.services.impl;

import com.words.memorization.words.service.repositories.KanjiRepository;
import com.words.memorization.words.service.services.KanjiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("kanjiService")
public class KanjiServiceImpl implements KanjiService {

    @Autowired
    private KanjiRepository kanjiRepository;

}
