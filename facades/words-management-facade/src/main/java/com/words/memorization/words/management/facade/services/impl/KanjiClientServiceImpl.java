package com.words.memorization.words.management.facade.services.impl;

import com.words.memorization.words.facades.common.clients.KanjiServiceClient;
import com.words.memorization.words.facades.common.models.PostKanjiModel;
import com.words.memorization.words.management.facade.api.model.PostKanjiInput;
import com.words.memorization.words.management.facade.mapping.WordsMapper;
import com.words.memorization.words.management.facade.services.KanjiClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service("kanjiClientService")
public class KanjiClientServiceImpl implements KanjiClientService {

    @Autowired
    private KanjiServiceClient kanjiServiceClient;

    @Autowired
    private WordsMapper wordsMapper;

    @Override
    public UUID createKanji(PostKanjiInput kanjiInput) {
        PostKanjiModel postKanjiModel = wordsMapper.toPostKanjiModel(kanjiInput);
        return kanjiServiceClient.createKanji(postKanjiModel);
    }
}
