package com.words.memorization.words.management.facade.services;

import com.words.memorization.words.common.models.PagedOutput;
import com.words.memorization.words.common.models.Paging;
import com.words.memorization.words.facades.common.dto.KanjiDto;
import com.words.memorization.words.facades.common.enums.JLPTLevel;
import com.words.memorization.words.management.facade.api.model.PostKanjiInput;

import javax.validation.constraints.NotNull;
import java.util.UUID;

public interface KanjiClientService {

    KanjiDto getKanjiByDisplayText(@NotNull String displayText);

    KanjiDto getKanjiById(@NotNull UUID kanjiId);

    PagedOutput<KanjiDto> getKanjiList(JLPTLevel jlptLevel, @NotNull Paging paging);

    KanjiDto createKanji(@NotNull PostKanjiInput kanjiInput);

}
