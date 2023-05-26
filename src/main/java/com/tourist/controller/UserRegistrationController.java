package com.tourist.controller;


import com.tourist.entities.UserRegistration;
import com.tourist.payload.UserRegistrationDto;
import com.tourist.service.UserRegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class UserRegistrationController {


    private UserRegistrationService userRegistrationService;

    private final String uploadDirectory = "src/main/resources/static/user_profile_image/";

    @Autowired
    public UserRegistrationController(UserRegistrationService userRegistrationService) {
        this.userRegistrationService = userRegistrationService;
    }

    @GetMapping
    public ResponseEntity<List<UserRegistration>> getAllUsers() {
        List<UserRegistration> users = userRegistrationService.getAllUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserRegistration> getUserById(@PathVariable Long id) {
        Optional<UserRegistration> user = userRegistrationService.getUserById(id);
        return user.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
     //http://localhost:8080/api/users
     @PostMapping
     public ResponseEntity<UserRegistration> saveUser(@RequestParam("firstName") String firstName,
                                                      @RequestParam("lastName") String lastName,
                                                      @RequestParam("email") String email,
                                                      @RequestParam("mobile") String mobile,
                                                      @RequestParam("city") String city,
                                                      @RequestParam("state") String state,
                                                      @RequestParam("country") String country,
                                                      @RequestParam("pinCode") String pinCode,
                                                      @RequestParam("password") String password,
                                                      @RequestParam("profileImage") MultipartFile profileImage) throws IOException {
         UserRegistrationDto userRegistrationDto = new UserRegistrationDto(firstName, lastName, email, mobile, city, state, country, pinCode, password, profileImage);
         UserRegistration userRegistration = userRegistrationService.saveUser(userRegistrationDto);
         return new ResponseEntity<>(userRegistration, HttpStatus.CREATED);
     }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        userRegistrationService.deleteUser(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    public void readFile(String fileName) {
        try (FileInputStream inputStream = new FileInputStream(fileName)) {
            // Do something with the input stream
        } catch (IOException e) {
            // Handle the exception
        }
    }

}






