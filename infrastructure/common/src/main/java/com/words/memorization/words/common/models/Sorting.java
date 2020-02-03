package com.words.memorization.words.common.models;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(description = "Sorting")
public class Sorting {
    
    @ApiModelProperty(value = "Sort by", position = 1,
        example = "date_created",
        allowEmptyValue = true)
    private String sortBy;

    @ApiModelProperty(value = "Sort order", position = 2,
        notes = "Default value - ASC. Available values - ASC, DESC",
        allowEmptyValue = true)
    private SortOrder sortOrder;
}
