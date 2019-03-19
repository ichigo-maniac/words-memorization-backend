package com.words.memorization.words.management.facade.services;

import com.words.memorization.words.management.facade.api.model.PostKanjiInput;
import java.util.UUID;

public interface KanjiClientService {

    UUID createKanji(PostKanjiInput kanjiInput);

}
