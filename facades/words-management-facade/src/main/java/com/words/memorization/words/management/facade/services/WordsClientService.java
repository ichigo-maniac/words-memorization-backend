package com.words.memorization.words.management.facade.services;

import com.words.memorization.words.common.models.PagedOutput;
import com.words.memorization.words.common.models.Paging;
import com.words.memorization.connector.words.service.dto.WordDto;
import com.words.memorization.connector.words.service.enums.JLPTLevel;
import com.words.memorization.words.management.facade.api.model.PostWordInput;

import javax.validation.constraints.NotNull;
import java.util.UUID;

public interface WordsClientService {

    WordDto getWordByDisplayText(@NotNull String displayText);

    WordDto getWordById(@NotNull UUID wordId);

    PagedOutput<WordDto> getWordsList(JLPTLevel jlptLevel, @NotNull Paging paging);

    WordDto createWord(@NotNull PostWordInput wordInput);

}
