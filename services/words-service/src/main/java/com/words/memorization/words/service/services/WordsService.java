package com.words.memorization.words.service.services;

import com.words.memorization.words.service.api.model.PostWordInput;
import com.words.memorization.words.service.entities.WordEntity;
import com.words.memorization.words.service.enums.JLPTLevel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import javax.validation.constraints.NotNull;
import java.util.UUID;

public interface WordsService {

    WordEntity getWordByDisplayText(@NotNull String displayText);

    WordEntity getWordById(@NotNull UUID wordId);

    Page<WordEntity> getWordsList(JLPTLevel jlptLevel, @NotNull Pageable pageable);

    WordEntity createWord(@NotNull PostWordInput wordInput);

}
