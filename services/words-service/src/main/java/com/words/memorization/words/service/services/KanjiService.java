package com.words.memorization.words.service.services;

import com.words.memorization.words.service.api.model.PostKanjiInput;
import com.words.memorization.words.service.entities.KanjiEntity;

public interface KanjiService {

    KanjiEntity getKanjiByDisplayText(String displayText);

    KanjiEntity createKanji(PostKanjiInput kanjiInput);

}
