package com.words.memorization.connector.users.service.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter @Setter
public class AbstractDto {

    @ApiModelProperty(value = "ID")
    private UUID id;
}
