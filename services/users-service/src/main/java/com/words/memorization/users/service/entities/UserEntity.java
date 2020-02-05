package com.words.memorization.users.service.entities;

import com.words.memorization.common.services.entities.AbstractEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * User entity class
 */
@Entity(name = "User")
@Table(name = "users")
@Getter @Setter
public class UserEntity extends AbstractEntity {

    /**
     * E-mail
     */
    @Column(name = "email", nullable = false, unique = true, length = 512)
    private String email;

    /**
     * Password
     */
    @Column(name = "password", nullable = false, length = 512)
    private String password;

    /**
     * Is user blocked
     */
    @Column(name = "is_blocked", nullable = false)
    private Boolean isBlocked;

}
