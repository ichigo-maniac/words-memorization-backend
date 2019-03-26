package com.words.memorization.words.facades.common.dto;

import com.words.memorization.words.facades.common.enums.JLPTLevel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class WordDto extends AbstractDto {

    @ApiModelProperty(value = "JLPT Level", example = "N5")
    private JLPTLevel jlptLevel;

    @ApiModelProperty(value = "Display text", example = "日本語", required = true, position = 1)
    private String displayText;

    @ApiModelProperty(value = "Hiragana text", example = "にほんご", required = true, position = 2)
    private String hiraganaText;

    @ApiModelProperty(value = "Eng translate", example = "Japanese language", position = 3)
    private String enTranslate;

    @ApiModelProperty(value = "Rus translate", example = "Японский язык", position = 4)
    private String ruTranslate;

}
