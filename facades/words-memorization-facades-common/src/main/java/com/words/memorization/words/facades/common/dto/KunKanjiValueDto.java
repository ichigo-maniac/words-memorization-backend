package com.words.memorization.words.facades.common.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class KunKanjiValueDto extends AbstractDto {

    @ApiModelProperty(value = "Display text", example = "にち", required = true)
    private String displayText;

}
