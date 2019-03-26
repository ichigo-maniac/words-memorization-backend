package com.words.memorization.words.service.services;

import com.words.memorization.words.service.api.model.PostKanjiInput;
import com.words.memorization.words.service.entities.KanjiEntity;
import java.util.UUID;

public interface KanjiService {

    KanjiEntity getKanjiByDisplayText(String displayText);

    KanjiEntity getKanjiById(UUID kanjiId);

    KanjiEntity createKanji(PostKanjiInput kanjiInput);

}
