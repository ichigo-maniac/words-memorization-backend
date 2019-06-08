package com.words.memorization.words.service.specifications;

import com.words.memorization.words.service.entities.KanjiEntity;
import com.words.memorization.words.service.entities.KanjiEntity_;
import com.words.memorization.words.service.enums.JLPTLevel;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.JoinType;

public class KanjiSpecification {

    public static Specification<KanjiEntity> fetchOnAndKunValues() {
        return (Specification<KanjiEntity>) (root, query, builder) -> {
            Class clazz = query.getResultType();
            if (!clazz.equals(Long.class) && !clazz.equals(long.class)) {
                root.fetch(KanjiEntity_.onValues, JoinType.LEFT);
                root.fetch(KanjiEntity_.kunValues, JoinType.LEFT);
            }
            return builder.conjunction();
        };
    }

    public static Specification<KanjiEntity> byJlptLevel(JLPTLevel jlptLevel) {
        return (Specification<KanjiEntity>) (root, query, builder) ->
                builder.equal(root.get(KanjiEntity_.jlptLevel), jlptLevel);
    }

}
