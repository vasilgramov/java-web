package com.social.models.bindingModels;

import com.social.customValidations.IsPasswordsMatching;

import javax.validation.constraints.Size;

@IsPasswordsMatching
public class RegistrationModel {

    @Size(min = 5, message = "Username too short!")
    private String username;

    @Size(min = 5, message = "Password too short!")
    private String password;

    private String confirmPassword;

    public RegistrationModel() {
        super();
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return this.confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }
}
