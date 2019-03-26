package com.words.memorization.words.service.services.impl;

import com.words.memorization.words.common.exceptions.BusinessException;
import com.words.memorization.words.service.api.model.PostWordInput;
import com.words.memorization.words.service.entities.WordEntity;
import com.words.memorization.words.service.mapping.WordsMapper;
import com.words.memorization.words.service.repositories.WordRepository;
import com.words.memorization.words.service.services.WordsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.util.Optional;
import java.util.UUID;

@Service("wordsService")
public class WordsServiceImpl implements WordsService {

    @Autowired
    private WordRepository wordRepository;

    @Autowired
    private WordsMapper wordsMapper;

    @Override
    public WordEntity getWordByDisplayText(@NotNull String displayText) {
        return wordRepository.getWordByDisplayText(displayText);
    }

    @Override
    public WordEntity getWordById(@NotNull UUID wordId) {
        Optional<WordEntity> wordResult = wordRepository.findById(wordId);
        return wordResult.orElse(null);
    }

    @Override
    public WordEntity createWord(@NotNull PostWordInput wordInput) {
        if (wordRepository.getWordByDisplayText(wordInput.getDisplayText()) != null) {
            throw new BusinessException("E00", "A word with display text " + wordInput.getDisplayText() + " exists");
        }
        WordEntity wordEntity = wordsMapper.toWordEntity(wordInput);
        return wordRepository.saveAndFlush(wordEntity);
    }
}
