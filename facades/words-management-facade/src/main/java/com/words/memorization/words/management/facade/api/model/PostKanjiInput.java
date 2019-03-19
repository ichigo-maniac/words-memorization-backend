package com.words.memorization.words.management.facade.api.model;

import com.words.memorization.words.facades.common.enums.JLPTLevel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter @Setter
public class PostKanjiInput {

    @ApiModelProperty(value = "JLPT Level", example = "N5")
    private JLPTLevel jlptLevel;

    @ApiModelProperty(value = "Display text", example = "日")
    @NotNull(message = "Display text can't be null or empty")
    @Size(min = 1, max = 1, message = "Kanji display text size must be 1 sign")
    private String displayText;

}
