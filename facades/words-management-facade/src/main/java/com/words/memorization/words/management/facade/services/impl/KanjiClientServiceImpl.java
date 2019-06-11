package com.words.memorization.words.management.facade.services.impl;

import com.words.memorization.words.common.exceptions.BusinessException;
import com.words.memorization.words.common.models.PagedOutput;
import com.words.memorization.words.common.models.Paging;
import com.words.memorization.words.facades.common.clients.KanjiServiceClient;
import com.words.memorization.words.facades.common.dto.KanjiDto;
import com.words.memorization.words.facades.common.enums.JLPTLevel;
import com.words.memorization.words.facades.common.models.PostKanjiModel;
import com.words.memorization.words.management.facade.api.model.PostKanjiInput;
import com.words.memorization.words.management.facade.mapping.WordsMapper;
import com.words.memorization.words.management.facade.services.KanjiClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@Service("kanjiClientService")
public class KanjiClientServiceImpl implements KanjiClientService {

    @Autowired
    private KanjiServiceClient kanjiServiceClient;

    @Autowired
    private WordsMapper wordsMapper;

    @Override
    public KanjiDto getKanjiByDisplayText(@NotNull String displayText) {
        return kanjiServiceClient.getKanjiByDisplayText(displayText);
    }

    @Override
    public KanjiDto getKanjiById(@NotNull UUID kanjiId) {
        return kanjiServiceClient.getKanjiById(kanjiId);
    }

    @Override
    public PagedOutput<KanjiDto> getKanjiList(JLPTLevel jlptLevel, @NotNull Paging paging) {
        return kanjiServiceClient.getKanjiList(paging.getPage(), paging.getPageSize(), jlptLevel);
    }

    @Override
    public KanjiDto createKanji(@NotNull PostKanjiInput kanjiInput) {
        if (kanjiServiceClient.getKanjiByDisplayText(kanjiInput.getDisplayText()) != null) {
            throw new BusinessException("E00", "A kanji with display text " + kanjiInput.getDisplayText() + " exists");
        }
        PostKanjiModel postKanjiModel = wordsMapper.toPostKanjiModel(kanjiInput);
        return kanjiServiceClient.createKanji(postKanjiModel);
    }
}
