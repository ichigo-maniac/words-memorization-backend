package com.words.memorization.words.service.services.impl;

import com.words.memorization.words.service.api.model.PostKanjiInput;
import com.words.memorization.words.service.entities.KanjiEntity;
import com.words.memorization.words.service.mapping.WordsMapper;
import com.words.memorization.words.service.repositories.KanjiRepository;
import com.words.memorization.words.service.services.KanjiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;

@Service("kanjiService")
public class KanjiServiceImpl implements KanjiService {

    @Autowired
    private KanjiRepository kanjiRepository;

    private WordsMapper wordsMapper;

    @Override
    public KanjiEntity createKanji(@NotNull PostKanjiInput kanjiInput) {
        KanjiEntity kanjiEntity = wordsMapper.toKanjiEntity(kanjiInput);
        return kanjiRepository.save(kanjiEntity);
    }
}
