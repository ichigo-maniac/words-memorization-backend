package com.words.memorization.connector.words.service.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class OnKanjiValueDto extends AbstractDto {

    @ApiModelProperty(value = "Display text", example = "匕", required = true)
    private String displayText;

}
