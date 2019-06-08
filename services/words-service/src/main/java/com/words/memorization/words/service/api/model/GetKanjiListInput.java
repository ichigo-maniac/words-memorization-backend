package com.words.memorization.words.service.api.model;

import com.words.memorization.words.service.enums.JLPTLevel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class GetKanjiListInput {

    @ApiModelProperty(value = "JLPT Level", example = "N5")
    private JLPTLevel jlptLevel;

}
