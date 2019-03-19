package com.words.memorization.words.management.facade.mapping;

import com.words.memorization.words.facades.common.models.PostKanjiModel;
import com.words.memorization.words.management.facade.api.model.PostKanjiInput;
import org.mapstruct.Mapper;

@Mapper
public interface WordsMapper {

    PostKanjiModel toPostKanjiModel(PostKanjiInput kanjiInput);

}
