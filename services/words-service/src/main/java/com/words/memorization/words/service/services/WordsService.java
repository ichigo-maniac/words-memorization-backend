package com.words.memorization.words.service.services;

import com.words.memorization.words.service.api.model.PostWordInput;
import com.words.memorization.words.service.entities.WordEntity;

import java.util.UUID;

public interface WordsService {

    WordEntity getWordByDisplayText(String displayText);

    WordEntity getWordById(UUID wordId);

    WordEntity createWord(PostWordInput wordInput);

}
