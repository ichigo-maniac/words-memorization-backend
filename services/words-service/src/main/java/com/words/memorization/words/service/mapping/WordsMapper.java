package com.words.memorization.words.service.mapping;

import com.words.memorization.words.service.api.dto.KanjiDto;
import com.words.memorization.words.service.api.model.PostKanjiInput;
import com.words.memorization.words.service.entities.KanjiEntity;
import org.mapstruct.Mapper;

@Mapper
public interface WordsMapper {

    KanjiDto toKanjiDto(KanjiEntity kanjiEntity);

    KanjiEntity toKanjiEntity(PostKanjiInput kanjiInput);

}
