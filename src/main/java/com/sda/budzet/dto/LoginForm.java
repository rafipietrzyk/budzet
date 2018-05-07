package com.sda.budzet.dto;

import com.sda.budzet.utils.ValidationUtils;

public class LoginForm implements Validator {
    private String login;
    private String password;

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

    @Override
    public boolean isValid() {
        if (!ValidationUtils.isNotEmptyAndNotContainWhitespace(login)){
            return false;
        }
        if (!ValidationUtils.isNotEmptyAndNotContainWhitespace(password)){
            return false;
        }
        return true;
    }
}
