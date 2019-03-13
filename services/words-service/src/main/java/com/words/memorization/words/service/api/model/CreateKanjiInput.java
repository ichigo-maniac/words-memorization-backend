package com.words.memorization.words.service.api.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter @Setter
public class CreateKanjiInput {

    @ApiModelProperty(value = "Display tet", required = true)
    @NotNull(message = "Display text can't be null")
    @Size(min = 1, max = 10, message = "Display text min size is 1")
    private String displayText;

}
