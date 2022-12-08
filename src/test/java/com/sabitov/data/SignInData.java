package com.sabitov.data;

import com.sabitov.Settings;

public class SignInData {
    public static final String validUsername = Settings.getUsername();
    public static final String validPassword = Settings.getPassword();
    public static final String invalidUsername = "IncorrectUsername";
    public static final String invalidPassword = "IncorrectPassword";
}
