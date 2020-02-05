package com.words.memorization.connector.users.service.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class UserDto extends AbstractDto {

    private String email;

    private String password;

    private Boolean isBlocked;
}
