package com.words.memorization.words.service.specifications;

import com.words.memorization.words.service.entities.KanjiEntity;
import com.words.memorization.words.service.entities.KanjiEntity_;
import com.words.memorization.words.service.enums.JLPTLevel;
import org.springframework.data.jpa.domain.Specification;

public class KanjiSpecification {

    public static Specification<KanjiEntity> byJlptLevel(JLPTLevel jlptLevel) {
        return (Specification<KanjiEntity>) (root, query, builder) ->
                builder.equal(root.get(KanjiEntity_.jlptLevel), jlptLevel);
    }

}
