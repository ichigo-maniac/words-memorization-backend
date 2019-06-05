package com.words.memorization.words.management.facade.api.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@Setter
public class PostKunKanjiValueInput {

    @ApiModelProperty(value = "Display text", example = "ひ", required = true)
    @NotBlank(message = "Display text can't be null or empty")
    @Size(max = 255, message = "Kanji's kun value display text max size is 255 signs")
    private String displayText;

}