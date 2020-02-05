package com.words.memorization.users.service.api.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class UserDto extends AbstractDto {

    private String email;

    private String password;

    private Boolean isBlocked;

}
