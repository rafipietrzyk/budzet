package com.sda.budzet.dto;

import com.sda.budzet.utils.ValidationUtils;

public class RegistrationForm implements Validator{
    private String login;
    private String password;
    private String repeatPassword;
    private String email;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRepeatPassword() {
        return repeatPassword;
    }

    public void setRepeatPassword(String repeatPassword) {
        this.repeatPassword = repeatPassword;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean isValid() {
        if (!ValidationUtils.isNotEmptyAndNotContainWhitespace(login)){
            return false;
        }
        if (!ValidationUtils.isNotEmptyAndNotContainWhitespace(password)){
            return false;
        }
        if (!ValidationUtils.isNotEmptyAndNotContainWhitespace(repeatPassword)){
            return false;
        }
        if (!ValidationUtils.isNotEmptyAndNotContainWhitespace(email)){
            return false;
        }
        if (!password.equals(repeatPassword)){
            return false;
        }
        return true;
    }
}
