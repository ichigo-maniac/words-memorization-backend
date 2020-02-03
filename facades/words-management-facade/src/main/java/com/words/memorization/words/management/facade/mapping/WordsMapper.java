package com.words.memorization.words.management.facade.mapping;

import com.words.memorization.connector.words.service.models.PostKanjiModel;
import com.words.memorization.connector.words.service.models.PostKunKanjiValueModel;
import com.words.memorization.connector.words.service.models.PostOnKanjiValueModel;
import com.words.memorization.connector.words.service.models.PostWordModel;
import com.words.memorization.words.management.facade.api.model.PostKanjiInput;
import com.words.memorization.words.management.facade.api.model.PostKunKanjiValueInput;
import com.words.memorization.words.management.facade.api.model.PostOnKanjiValueInput;
import com.words.memorization.words.management.facade.api.model.PostWordInput;
import org.mapstruct.Mapper;

@Mapper
public interface WordsMapper {

    PostKanjiModel toPostKanjiModel(PostKanjiInput kanjiInput);

    PostOnKanjiValueModel toPostOnKanjiValueModel(PostOnKanjiValueInput onKanjiValueInput);

    PostKunKanjiValueModel toPostKunKanjiValueModel(PostKunKanjiValueInput kunKanjiValueInput);

    PostWordModel toPostWordModel(PostWordInput postWordInput);

}
