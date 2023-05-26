package com.tourist.service;

import com.tourist.entities.UserRegistration;
import com.tourist.payload.UserRegistrationDto;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

public interface UserRegistrationService {


    List<UserRegistration> getAllUsers();

    Optional<UserRegistration> getUserById(Long id);

    UserRegistration saveUser(UserRegistrationDto userRegistrationDto) throws IOException;

    void deleteUser(Long id);
}