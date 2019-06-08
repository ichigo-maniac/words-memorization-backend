package com.words.memorization.words.service.services;

import com.words.memorization.words.service.api.model.PostKanjiInput;
import com.words.memorization.words.service.entities.KanjiEntity;
import com.words.memorization.words.service.enums.JLPTLevel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import javax.validation.constraints.NotNull;
import java.util.UUID;

public interface KanjiService {

    KanjiEntity getKanjiByDisplayText(@NotNull String displayText);

    KanjiEntity getKanjiById(@NotNull UUID kanjiId);

    Page<KanjiEntity> getKanjiList(JLPTLevel jlptLevel, @NotNull Pageable pageable);

    KanjiEntity createKanji(@NotNull PostKanjiInput kanjiInput);

}
