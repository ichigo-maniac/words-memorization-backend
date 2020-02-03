package com.words.memorization.words.common.utils;

import com.words.memorization.words.common.exceptions.BusinessError;
import com.words.memorization.words.common.exceptions.BusinessException;
import com.words.memorization.words.common.models.Paging;
import com.words.memorization.words.common.models.SortOrder;
import com.words.memorization.words.common.models.Sorting;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.util.StringUtils;
import java.util.HashMap;
import java.util.Map;

public class PageableUtils {

    public static final Sort makeSort(
            Sorting sorting,
            Sorting defaultSorting,
            Map.Entry<String, Sort>... sortMap) {
        Sorting s = new Sorting();
        s.setSortBy(StringUtils.isEmpty(sorting.getSortBy()) ? defaultSorting.getSortBy() : sorting.getSortBy());
        s.setSortOrder(sorting.getSortOrder() == null
                ? (StringUtils.isEmpty(sorting.getSortBy()) ? defaultSorting.getSortOrder() : SortOrder.ASC)
                : sorting.getSortOrder());

        Sort sort = Sort.unsorted();
        String sortBy = s.getSortBy();
        if (!StringUtils.isEmpty(sortBy)) {
            final Map<String, Sort> sm = new HashMap<>();
            for (Map.Entry<String, Sort> entry : sortMap) {
                if (!StringUtils.isEmpty(entry.getKey()) && entry.getValue() != null) {
                    sm.put(entry.getKey().toUpperCase(), entry.getValue());
                }
            }

            if (sm.isEmpty()) {
                sort = Sort.by(sortBy);
            } else {
                String normalizedSortBy = sortBy.toUpperCase();
                if (sm.containsKey(normalizedSortBy)) {
                    sort = sm.get(normalizedSortBy);
                } else {
                    throw new BusinessException(BusinessError.E000, "Sorting by '" + sortBy + "' is impossible");
                }
            }

            sort = s.getSortOrder() == SortOrder.DESC ? sort.descending() : sort.ascending();
        }
        return sort;
    }

    public static final Pageable makePageable(Paging paging) {
        return PageRequest.of(paging.getPage(), paging.getPageSize());
    }

    public static final Pageable makePageable(
            Paging paging,
            Sorting sorting,
            Sorting defaultSorting,
            Map.Entry<String, Sort>... sortMap) {
        return PageRequest.of(paging.getPage(), paging.getPageSize(), makeSort(sorting, defaultSorting, sortMap));
    }

}
