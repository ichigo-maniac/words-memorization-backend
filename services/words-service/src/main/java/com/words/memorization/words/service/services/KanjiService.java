package com.words.memorization.words.service.services;

import com.words.memorization.words.service.api.model.PostKanjiInput;
import com.words.memorization.words.service.entities.KanjiEntity;
import com.words.memorization.words.service.enums.JLPTLevel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.UUID;

public interface KanjiService {

    KanjiEntity getKanjiByDisplayText(String displayText);

    KanjiEntity getKanjiById(UUID kanjiId);

    Page<KanjiEntity> getKanjiList(JLPTLevel jlptLevel, Pageable pageable);

    KanjiEntity createKanji(PostKanjiInput kanjiInput);

}
