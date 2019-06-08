package com.words.memorization.words.common.models;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor @NoArgsConstructor
public class PagedOutput<T> extends Output {

    @ApiModelProperty(value = "List of items", position = 1)
    private List<T> items;

    @ApiModelProperty(notes = "Current page number", position = 2)
    private int page;

    @ApiModelProperty(notes = "Pages total count", position = 3)
    private int totalPages;

    @ApiModelProperty(notes = "Items total count", position = 4)
    private long totalItems;
}
