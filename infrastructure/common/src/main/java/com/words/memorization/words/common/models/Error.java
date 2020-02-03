package com.words.memorization.words.common.models;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString
@ApiModel(description = "Error")
public class Error {

    @ApiModelProperty(notes = "Error's code", example = "E000", position = 0)
    private String code;

    @ApiModelProperty(notes = "Error's message", example = "Internal error", position = 1)
    private String message;

    @ApiModelProperty(notes = "Details", position = 2)
    private String details;
}
