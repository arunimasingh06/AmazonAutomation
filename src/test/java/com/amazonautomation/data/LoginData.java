package com.amazonautomation.data;

import org.testng.annotations.DataProvider;

import java.io.IOException;

public class LoginData {

    @DataProvider(name = "loginData")
    public static Object[][] loginData() throws IOException {
        return new Object[][]{
                {"standard_user", "secret_sauce", true},
                {"standard_user", "wrongPassword", false},
                {"wronguser", "secret_sauce", false},
                {"wronguser", "wrongPassword", false}
        };
    }
}