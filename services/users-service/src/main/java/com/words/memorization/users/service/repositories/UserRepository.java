package com.words.memorization.users.service.repositories;

import com.words.memorization.users.service.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface UserRepository extends JpaRepository<UserEntity, UUID> {

    Boolean existsByEmail(String email);

    Optional<UserEntity> findByEmail(String email);

}
