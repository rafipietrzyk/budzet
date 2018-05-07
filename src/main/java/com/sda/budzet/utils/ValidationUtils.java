package com.sda.budzet.utils;

public class ValidationUtils {
    public static boolean isNotEmptyAndNotContainWhitespace(String value){
        if (value == null || value.isEmpty() || value.contains(" ")){
            return false;
        }
        return true;
    }
}
