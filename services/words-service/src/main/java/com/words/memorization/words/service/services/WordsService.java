package com.words.memorization.words.service.services;

import com.words.memorization.words.service.api.model.PostWordInput;
import com.words.memorization.words.service.entities.WordEntity;

import javax.validation.constraints.NotNull;
import java.util.UUID;

public interface WordsService {

    WordEntity getWordByDisplayText(@NotNull String displayText);

    WordEntity getWordById(@NotNull UUID wordId);

    WordEntity createWord(@NotNull PostWordInput wordInput);

}
