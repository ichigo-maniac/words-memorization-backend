package com.words.memorization.words.facades.common.dto;

import com.words.memorization.words.facades.common.enums.JLPTLevel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class KanjiDto extends AbstractDto {

    @ApiModelProperty(value = "Display text", example = "日", required = true)
    private String displayText;

    @ApiModelProperty(value = "JLPT level", example = "N5")
    private JLPTLevel jlptLevel;
}
