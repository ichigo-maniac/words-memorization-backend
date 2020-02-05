package com.words.memorization.users.service.services;

import com.words.memorization.users.service.entities.UserEntity;

import javax.validation.constraints.NotBlank;

public interface UsersService {

    Boolean userExistsByEmail(@NotBlank String email);

    UserEntity getUserByEmail(@NotBlank String email);

}
