package com.words.memorization.words.management.facade.services;

import com.words.memorization.words.facades.common.dto.WordDto;
import com.words.memorization.words.management.facade.api.model.PostWordInput;

public interface WordsClientService {

    WordDto getWordByDisplayText(String displayText);

    WordDto createWord(PostWordInput wordInput);

}
