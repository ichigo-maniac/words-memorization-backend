package com.words.memorization.words.common.utils;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.CollectionUtils;

import java.util.List;

public class SpecificationUtils {

    public static final <T> Specification<T> buildSpecification(List<Specification<T>> specifications) {
        if (!CollectionUtils.isEmpty(specifications)) {
            Specification<T> result = Specification.where(specifications.get(0));
            for (int i = 1; i < specifications.size(); i++) {
                result = result.and(specifications.get(i));
            }
            return result;
        } else {
            return null;
        }
    }

    public static final <T> Specification<T> buildSpecification(Specification<T> ...specifications) {
        if (specifications.length != 0) {
            Specification<T> result = Specification.where(specifications[0]);
            for (int i = 1; i < specifications.length; i++) {
                result = result.and(specifications[i]);
            }
            return result;
        } else {
            return null;
        }
    }
}
