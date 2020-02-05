package com.words.memorization.connector.users.service.clients;

import com.words.memorization.connector.users.service.dto.UserDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("users-service")
public interface UsersServiceClient {

    @GetMapping("/api/users/by_email/exists/{email}")
    Boolean userExistsByEmail(@PathVariable("email") String email);

    @GetMapping("/api/users/by_email/{email}")
    UserDto getUserByEmail(@PathVariable("email") String email);

}
