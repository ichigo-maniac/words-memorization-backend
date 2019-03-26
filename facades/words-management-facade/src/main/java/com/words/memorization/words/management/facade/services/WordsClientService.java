package com.words.memorization.words.management.facade.services;

import com.words.memorization.words.facades.common.dto.WordDto;
import com.words.memorization.words.management.facade.api.model.PostWordInput;

import java.util.UUID;

public interface WordsClientService {

    WordDto getWordByDisplayText(String displayText);

    WordDto getWordById(UUID wordId);

    WordDto createWord(PostWordInput wordInput);

}
