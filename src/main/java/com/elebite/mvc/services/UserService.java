package com.elebite.mvc.services;

import com.elebite.mvc.dto.RegistrationDto;
import com.elebite.mvc.models.UserEntity;

public interface UserService {
    void saveUser(RegistrationDto registrationDto);
    UserEntity findByEmail(String email);

    UserEntity findByUsername(String username);
}
