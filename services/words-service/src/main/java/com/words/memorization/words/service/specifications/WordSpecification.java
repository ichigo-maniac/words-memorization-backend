package com.words.memorization.words.service.specifications;

import com.words.memorization.words.service.entities.WordEntity;
import com.words.memorization.words.service.entities.WordEntity_;
import com.words.memorization.words.service.enums.JLPTLevel;
import org.springframework.data.jpa.domain.Specification;

public class WordSpecification {

    public static Specification<WordEntity> byJlptLevel(JLPTLevel jlptLevel) {
        return (Specification<WordEntity>) (root, query, builder) ->
                builder.equal(root.get(WordEntity_.jlptLevel), jlptLevel);
    }

}
