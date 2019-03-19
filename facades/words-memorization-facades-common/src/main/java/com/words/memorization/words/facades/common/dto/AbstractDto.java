package com.words.memorization.words.facades.common.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import java.util.UUID;

@Getter @Setter
public class AbstractDto {

    @ApiModelProperty(value = "ID")
    private UUID id;
}
