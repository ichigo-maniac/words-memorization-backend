package com.words.memorization.words.service.services.impl;

import com.words.memorization.words.common.exceptions.BusinessException;
import com.words.memorization.words.common.utils.SpecificationUtils;
import com.words.memorization.words.service.api.model.PostKanjiInput;
import com.words.memorization.words.service.entities.KanjiEntity;
import com.words.memorization.words.service.enums.JLPTLevel;
import com.words.memorization.words.service.mapping.WordsMapper;
import com.words.memorization.words.service.repositories.KanjiRepository;
import com.words.memorization.words.service.services.KanjiService;
import com.words.memorization.words.service.specifications.KanjiSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@Service("kanjiService")
public class KanjiServiceImpl implements KanjiService {

    @Autowired
    private KanjiRepository kanjiRepository;

    @Autowired
    private WordsMapper wordsMapper;

    @Override
    public KanjiEntity getKanjiByDisplayText(@NotNull String displayText) {
        return kanjiRepository.getKanjiByDisplayText(displayText);
    }

    @Override
    public KanjiEntity getKanjiById(@NotNull UUID kanjiId) {
        return kanjiRepository.getKanjiById(kanjiId);
    }

    @Override
    public Page<KanjiEntity> getKanjiList(JLPTLevel jlptLevel, Pageable pageable) {
        if (jlptLevel != null) {
            return kanjiRepository.findAll(
                    SpecificationUtils.buildSpecification(
                            KanjiSpecification.fetchOnAndKunValues(),
                            KanjiSpecification.byJlptLevel(jlptLevel)),
                            pageable);
        } else {
            return kanjiRepository.findAll(
                    SpecificationUtils.buildSpecification(KanjiSpecification.fetchOnAndKunValues()),
                    pageable);
        }
    }

    @Override
    public KanjiEntity createKanji(@NotNull PostKanjiInput kanjiInput) {
        if (kanjiRepository.getKanjiByDisplayText(kanjiInput.getDisplayText()) != null) {
            throw new BusinessException("E00", "A kanji with display text " + kanjiInput.getDisplayText() + " exists");
        }
        KanjiEntity kanjiEntity = wordsMapper.toKanjiEntity(kanjiInput);
        if (!CollectionUtils.isEmpty(kanjiEntity.getOnValues())) {
            kanjiEntity.getOnValues().forEach(onKanjiValueEntity -> onKanjiValueEntity.setKanji(kanjiEntity));
        }
        if (!CollectionUtils.isEmpty(kanjiEntity.getKunValues())) {
            kanjiEntity.getKunValues().forEach(kunKanjiValueEntity -> kunKanjiValueEntity.setKanji(kanjiEntity));
        }
        return kanjiRepository.saveAndFlush(kanjiEntity);
    }
}
