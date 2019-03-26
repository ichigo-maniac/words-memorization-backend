package com.words.memorization.words.service.services;

import com.words.memorization.words.service.api.model.PostWordInput;
import com.words.memorization.words.service.entities.WordEntity;

public interface WordsService {

    WordEntity getWordByDisplayText(String displayText);

    WordEntity createWord(PostWordInput wordInput);

}
