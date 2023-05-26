package com.tourist.service.Impl;


import com.tourist.entities.UserRegistration;
import com.tourist.payload.UserRegistrationDto;
import com.tourist.repository.UserRegistrationRepository;
import com.tourist.service.UserRegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class UserRegistrationServiceImpl implements UserRegistrationService {

    private UserRegistrationRepository userRegistrationRepository;

    private final String uploadDirectory = "src/main/resources/static/user_profile_image/";

    @Autowired
    public UserRegistrationServiceImpl(UserRegistrationRepository userRegistrationRepository) {
        this.userRegistrationRepository = userRegistrationRepository;
    }

    @Override
    public List<UserRegistration> getAllUsers() {
        return userRegistrationRepository.findAll();
    }

    @Override
    public Optional<UserRegistration> getUserById(Long id) {

        return userRegistrationRepository.findById(id);
    }

    @Override
    public UserRegistration saveUser(UserRegistrationDto userRegistrationDto) throws IOException {
        UserRegistration userRegistration = new UserRegistration();
        userRegistration.setFirstName(userRegistrationDto.getFirstName());
        userRegistration.setLastName(userRegistrationDto.getLastName());
        userRegistration.setEmail(userRegistrationDto.getEmail());
        userRegistration.setMobile(userRegistrationDto.getMobile());
        userRegistration.setCity(userRegistrationDto.getCity());
        userRegistration.setState(userRegistrationDto.getState());
        userRegistration.setCountry(userRegistrationDto.getCountry());
        userRegistration.setPinCode(userRegistrationDto.getPinCode());
        userRegistration.setPassword(userRegistrationDto.getPassword());
        userRegistration.setProfileImage(userRegistrationDto.getProfileImage());
        return userRegistrationRepository.save(userRegistration);
    }


    @Override
    public void deleteUser(Long id) {
        userRegistrationRepository.deleteById(id);
    }
}
