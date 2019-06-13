package com.words.memorization.words.management.facade.services.impl;

import com.words.memorization.words.common.exceptions.BusinessException;
import com.words.memorization.words.common.models.PagedOutput;
import com.words.memorization.words.common.models.Paging;
import com.words.memorization.words.facades.common.clients.WordsServiceClient;
import com.words.memorization.words.facades.common.dto.WordDto;
import com.words.memorization.words.facades.common.enums.JLPTLevel;
import com.words.memorization.words.facades.common.models.PostWordModel;
import com.words.memorization.words.management.facade.api.model.PostWordInput;
import com.words.memorization.words.management.facade.mapping.WordsMapper;
import com.words.memorization.words.management.facade.services.WordsClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.util.UUID;

@Service("wordsClientService")
public class WordsClientServiceImpl implements WordsClientService {

    @Autowired
    private WordsServiceClient wordsServiceClient;

    @Autowired
    private WordsMapper wordsMapper;

    @Override
    public WordDto getWordByDisplayText(@NotNull String displayText) {
        return wordsServiceClient.getWordByDisplayText(displayText);
    }

    @Override
    public WordDto getWordById(@NotNull UUID wordId) {
        return wordsServiceClient.getWordById(wordId);
    }

    @Override
    public PagedOutput<WordDto> getWordsList(JLPTLevel jlptLevel, @NotNull Paging paging) {
        return wordsServiceClient.getWordsList(paging.getPage(), paging.getPageSize(), jlptLevel);
    }

    @Override
    public WordDto createWord(@NotNull PostWordInput wordInput) {
        if (wordsServiceClient.getWordByDisplayText(wordInput.getDisplayText()) != null) {
            throw new BusinessException("E00", "A word with display text " + wordInput.getDisplayText() + " exists");
        }
        PostWordModel postWordModel = wordsMapper.toPostWordModel(wordInput);
        return wordsServiceClient.createWord(postWordModel);
    }
}
