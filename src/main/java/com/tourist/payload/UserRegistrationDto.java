package com.tourist.payload;



import lombok.Data;
import org.springframework.web.multipart.MultipartFile;
@Data
public class UserRegistrationDto {

    private String firstName;

    private String lastName;

    private String email;

    private String mobile;

    private String city;

    private String state;

    private String country;

    private String pinCode;

    private String password;

    private MultipartFile profileImage;

    public UserRegistrationDto() {
    }

    public UserRegistrationDto(String firstName, String lastName, String email, String mobile, String city, String state, String country, String pinCode, String password, MultipartFile profileImage) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.mobile = mobile;
        this.city = city;
        this.state = state;
        this.country = country;
        this.pinCode = pinCode;
        this.password = password;
        this.profileImage = profileImage;
    }

    // getters and setters for all fields

}
