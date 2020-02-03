package com.words.memorization.words.common.models;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Output {

    @ApiModelProperty(notes = "Errors", position = 100)
    private List<Error> errors;
}
