package com.words.memorization.users.service.mapping;

import com.words.memorization.users.service.api.dto.UserDto;
import com.words.memorization.users.service.entities.UserEntity;
import org.mapstruct.Mapper;

@Mapper
public interface UsersMapper {

    UserDto toUserDto(UserEntity userEntity);
}
