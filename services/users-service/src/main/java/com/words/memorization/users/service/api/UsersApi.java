package com.words.memorization.users.service.api;

import com.words.memorization.users.service.api.dto.UserDto;
import com.words.memorization.users.service.mapping.UsersMapper;
import com.words.memorization.users.service.services.UsersService;
import com.words.memorization.words.common.api.ApiBase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class UsersApi extends ApiBase {

    @Autowired
    private UsersService usersService;

    @Autowired
    private UsersMapper usersMapper;

    @GetMapping("/by_email/exists/{email}")
    public Boolean userExistsByEmail(@PathVariable("email") String email) {
        return usersService.userExistsByEmail(email);
    }

    @GetMapping("/by_email/{email}")
    public UserDto getUserByEmail(@PathVariable("email") String email) {
        return usersMapper.toUserDto(usersService.getUserByEmail(email));
    }

}
