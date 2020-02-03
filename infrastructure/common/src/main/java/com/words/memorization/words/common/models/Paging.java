package com.words.memorization.words.common.models;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@ToString
@ApiModel(description = "Page")
public class Paging {

    @ApiModelProperty(value = "Page number", position = 1,
            example = "0",
            allowEmptyValue = true)
    @Min(value = 0, message = "Page number must be positive or 0")
    @NotNull(message = "Page number can't be null")
    private Integer page;

    @ApiModelProperty(value = "Page size", position = 2,
            notes = "Default value - 20",
            example = "20",
            allowEmptyValue = true)
    @Min(value = 1, message = "Page size must be positive")
    @NotNull(message = "Page size can't be null")
    private Integer pageSize;
}
