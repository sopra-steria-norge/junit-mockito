package com.soprasteria.user;

import org.apache.commons.lang3.RandomStringUtils;

public class UserContext {
    public static String getCurrentUser() {
        return RandomStringUtils.randomAlphabetic(10);
    }
}
