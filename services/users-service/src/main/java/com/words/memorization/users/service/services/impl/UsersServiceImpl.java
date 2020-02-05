package com.words.memorization.users.service.services.impl;

import com.words.memorization.users.service.entities.UserEntity;
import com.words.memorization.users.service.repositories.UserRepository;
import com.words.memorization.users.service.services.UsersService;
import com.words.memorization.words.common.exceptions.BusinessError;
import com.words.memorization.words.common.exceptions.BusinessException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotBlank;

@Service
public class UsersServiceImpl implements UsersService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public Boolean userExistsByEmail(@NotBlank String email) {
        return userRepository.existsByEmail(email);
    }

    @Override
    public UserEntity getUserByEmail(@NotBlank String email) {
        return userRepository.findByEmail(email).orElseThrow(() -> new BusinessException(BusinessError.E000, "The user with email " + email + " doesn't exist"));
    }
}
