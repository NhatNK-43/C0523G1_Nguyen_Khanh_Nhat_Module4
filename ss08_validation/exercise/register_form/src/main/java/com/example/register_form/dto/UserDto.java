package com.example.register_form.dto;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class UserDto implements Validator {
    private int id;

    private String firstName;
    private String lastName;
    private String phoneNumber;
    private int age;
    private String email;

    public UserDto() {
    }

    public UserDto(int id, String firstName, String lastName, String phoneNumber, int age, String email) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.age = age;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        UserDto userDto = (UserDto) target;
        if (("").equals(userDto.getFirstName())) {
            errors.rejectValue("firstName", null, "Require not empty!");
        } else if (userDto.getFirstName().trim().length() < 5 || userDto.getFirstName().trim().length() > 45) {
            errors.rejectValue("firstName", null, "The first name has a minimum length of 5, maximum 45 characters!");
        }

        if (("").equals(userDto.getLastName())) {
            errors.rejectValue("lastName", null, "Require not empty!");
        } else if (userDto.getLastName().trim().length() < 5 || userDto.getFirstName().trim().length() > 45) {
            errors.rejectValue("lastName", null, "The last name has a minimum length of 5, maximum 45 characters!");
        }

        if (("").equals(userDto.getPhoneNumber())) {
            errors.rejectValue("phoneNumber", null, "Require not empty!");
        } else if (!userDto.getPhoneNumber().matches("^0[0-9]{9}$")) {
            errors.rejectValue("phoneNumber", null, "The number is invalid!");
        }

        if (userDto.getAge()<18){
            errors.rejectValue("age",null,"The age must be greater than 18!");
        }

        if (("").equals(userDto.getEmail())){
            errors.rejectValue("email", null, "Require not empty!");
        } else if (!userDto.getEmail().matches("^[A-Za-z0-9][A-Za-z0-9.]{5,29}@[a-z]+\\.[a-z]+$")){
            errors.rejectValue("email", null, "The email is invalid!");
        }
    }
}
