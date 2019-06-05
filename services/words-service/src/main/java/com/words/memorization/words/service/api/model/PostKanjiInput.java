package com.words.memorization.words.service.api.model;

import com.words.memorization.words.service.enums.JLPTLevel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;

@Getter @Setter
public class PostKanjiInput {

    @ApiModelProperty(value = "JLPT Level", example = "N5")
    private JLPTLevel jlptLevel;

    @ApiModelProperty(value = "Display text", example = "日", required = true, position = 1)
    @NotBlank(message = "Display text can't be null or empty")
    @Size(min = 1, max = 1, message = "Kanji display text size must be 1 sign")
    private String displayText;

    @Valid
    @ApiModelProperty(value = "On values", position = 2)
    private List<PostOnKanjiValueInput> onValues;

    @Valid
    @ApiModelProperty(value = "Kun values", position = 3)
    private List<PostKunKanjiValueInput> kunValues;

}
