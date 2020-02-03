package com.words.memorization.words.service.services.impl;

import com.words.memorization.words.common.exceptions.BusinessError;
import com.words.memorization.words.common.exceptions.BusinessException;
import com.words.memorization.words.common.utils.SpecificationUtils;
import com.words.memorization.words.service.api.model.PostWordInput;
import com.words.memorization.words.service.entities.WordEntity;
import com.words.memorization.words.service.enums.JLPTLevel;
import com.words.memorization.words.service.mapping.WordsMapper;
import com.words.memorization.words.service.repositories.WordRepository;
import com.words.memorization.words.service.services.WordsService;
import com.words.memorization.words.service.specifications.WordSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.util.Optional;
import java.util.UUID;

@Service("wordsService")
public class WordsServiceImpl implements WordsService {

    @Autowired
    private WordRepository wordRepository;

    @Autowired
    private WordsMapper wordsMapper;

    @Override
    public WordEntity getWordByDisplayText(@NotNull String displayText) {
        return wordRepository.getWordByDisplayText(displayText).orElseThrow(() -> new BusinessException(BusinessError.E000, "Word with display text " + displayText + " doesn't exist"));
    }

    @Override
    public WordEntity getWordById(@NotNull UUID wordId) {
        return wordRepository.findById(wordId).orElseThrow(() -> new BusinessException(BusinessError.E000, "Word with id " + wordId + " doesn't exist"));
    }

    @Override
    public Page<WordEntity> getWordsList(JLPTLevel jlptLevel, @NotNull Pageable pageable) {
        if (jlptLevel != null) {
            return wordRepository.findAll(
                    SpecificationUtils.buildSpecification(WordSpecification.byJlptLevel(jlptLevel)),
                    pageable);
        } else {
            return wordRepository.findAll(pageable);
        }
    }

    @Override
    public WordEntity createWord(@NotNull PostWordInput wordInput) {
        if (wordRepository.getWordByDisplayText(wordInput.getDisplayText()) != null) {
            throw new BusinessException("E00", "A word with display text " + wordInput.getDisplayText() + " exists");
        }
        WordEntity wordEntity = wordsMapper.toWordEntity(wordInput);
        return wordRepository.saveAndFlush(wordEntity);
    }
}
