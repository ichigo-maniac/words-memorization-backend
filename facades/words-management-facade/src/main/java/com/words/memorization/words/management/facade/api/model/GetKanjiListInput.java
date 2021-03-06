package com.words.memorization.words.management.facade.api.model;

import com.words.memorization.connector.words.service.enums.JLPTLevel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class GetKanjiListInput {

    @ApiModelProperty(value = "JLPT Level", example = "N5")
    private JLPTLevel jlptLevel;

}
