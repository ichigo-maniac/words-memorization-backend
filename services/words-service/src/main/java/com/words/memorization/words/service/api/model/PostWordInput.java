package com.words.memorization.words.service.api.model;

import com.words.memorization.words.service.enums.JLPTLevel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter @Setter
public class PostWordInput {

    @ApiModelProperty(value = "JLPT Level", example = "N5")
    private JLPTLevel jlptLevel;

    @ApiModelProperty(value = "Display text", example = "日本語", required = true, position = 1)
    @NotBlank(message = "Display text can't be null or empty")
    @Size(max = 255, message = "Word's display text max size is 255 signs")
    private String displayText;

    @ApiModelProperty(value = "Hiragana text", example = "にほんご", required = true, position = 2)
    @NotBlank(message = "Hiragana text can't be null or empty")
    @Size(max = 255, message = "Hiragana text max size is 255 signs")
    private String hiraganaText;

    @ApiModelProperty(value = "Eng translate", example = "Japanese language", position = 3)
    @Size(max = 255, message = "Eng translate text max size is 255 signs")
    private String enTranslate;

    @ApiModelProperty(value = "Rus translate", example = "Японский язык", position = 4)
    @Size(max = 255, message = "Rus translate text max size is 255 signs")
    private String ruTranslate;

}
