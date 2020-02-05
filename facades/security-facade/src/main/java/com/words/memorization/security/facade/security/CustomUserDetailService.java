package com.words.memorization.security.facade.security;

import com.words.memorization.connector.users.service.clients.UsersServiceClient;
import com.words.memorization.connector.users.service.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Collections;

@Service
public class CustomUserDetailService implements UserDetailsService {

    @Autowired
    private UsersServiceClient usersServiceClient;

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        String email = !StringUtils.isEmpty(login) ? login.trim() : "";
        if (usersServiceClient.userExistsByEmail(email)) {
            UserDto user = usersServiceClient.getUserByEmail(email);
            return !user.getIsBlocked() ? new User(user.getEmail(), user.getPassword(), Collections.emptyList()) : null;
        } else {
            return null;
        }
    }
}
