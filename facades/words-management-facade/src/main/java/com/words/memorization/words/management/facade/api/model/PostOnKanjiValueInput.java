package com.words.memorization.words.management.facade.api.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@Setter
public class PostOnKanjiValueInput {

    @ApiModelProperty(value = "Display text", example = "匕", required = true)
    @NotBlank(message = "Display text can't be null or empty")
    @Size(max = 255, message = "Kanji's on value display text max size is 255 signs")
    private String displayText;

}
