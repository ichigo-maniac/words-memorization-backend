package com.words.memorization.words.service.api.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter @Setter
public abstract class AbstractDto {

    @ApiModelProperty(value = "ID")
    private UUID id;

}
