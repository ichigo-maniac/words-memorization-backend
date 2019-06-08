package com.words.memorization.words.management.facade.services;

import com.words.memorization.words.facades.common.dto.KanjiDto;
import com.words.memorization.words.management.facade.api.model.PostKanjiInput;

import javax.validation.constraints.NotNull;
import java.util.UUID;

public interface KanjiClientService {

    KanjiDto getKanjiByDisplayText(@NotNull String displayText);

    KanjiDto getKanjiById(@NotNull UUID kanjiId);

    KanjiDto createKanji(@NotNull PostKanjiInput kanjiInput);

}
