package com.words.memorization.words.management.facade.services;

import com.words.memorization.words.facades.common.dto.WordDto;
import com.words.memorization.words.management.facade.api.model.PostWordInput;

import javax.validation.constraints.NotNull;
import java.util.UUID;

public interface WordsClientService {

    WordDto getWordByDisplayText(@NotNull String displayText);

    WordDto getWordById(@NotNull UUID wordId);

    WordDto createWord(@NotNull PostWordInput wordInput);

}
