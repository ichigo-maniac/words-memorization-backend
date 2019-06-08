package com.words.memorization.words.service.mapping;

import com.words.memorization.words.service.api.dto.KanjiDto;
import com.words.memorization.words.service.api.dto.KunKanjiValueDto;
import com.words.memorization.words.service.api.dto.OnKanjiValueDto;
import com.words.memorization.words.service.api.dto.WordDto;
import com.words.memorization.words.service.api.model.PostKanjiInput;
import com.words.memorization.words.service.api.model.PostKunKanjiValueInput;
import com.words.memorization.words.service.api.model.PostOnKanjiValueInput;
import com.words.memorization.words.service.api.model.PostWordInput;
import com.words.memorization.words.service.entities.KanjiEntity;
import com.words.memorization.words.service.entities.KunKanjiValueEntity;
import com.words.memorization.words.service.entities.OnKanjiValueEntity;
import com.words.memorization.words.service.entities.WordEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface WordsMapper {

    KanjiDto toKanjiDto(KanjiEntity kanjiEntity);

    List<KanjiDto> toKanjiDtoList(List<KanjiEntity> kanjiEntities);

    KanjiEntity toKanjiEntity(PostKanjiInput kanjiInput);

    OnKanjiValueEntity toOnKanjiValueEntity(PostOnKanjiValueInput onKanjiValueInput);

    KunKanjiValueEntity toKunKanjiValueEntity(PostKunKanjiValueInput kunKanjiValueInput);

    OnKanjiValueDto toOnKanjiValueDto(OnKanjiValueEntity onKanjiValueEntity);

    KunKanjiValueDto toKunKanjiValueDto(KunKanjiValueEntity kunKanjiValueEntity);

    WordDto toWordDto(WordEntity wordEntity);

    WordEntity toWordEntity(PostWordInput wordInput);

}
