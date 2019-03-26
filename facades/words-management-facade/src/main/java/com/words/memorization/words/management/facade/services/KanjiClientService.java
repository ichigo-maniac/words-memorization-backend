package com.words.memorization.words.management.facade.services;

import com.words.memorization.words.facades.common.dto.KanjiDto;
import com.words.memorization.words.management.facade.api.model.PostKanjiInput;

import java.util.UUID;

public interface KanjiClientService {

    KanjiDto getKanjiByDisplayText(String displayText);

    KanjiDto getKanjiById(UUID kanjiId);

    KanjiDto createKanji(PostKanjiInput kanjiInput);

}
