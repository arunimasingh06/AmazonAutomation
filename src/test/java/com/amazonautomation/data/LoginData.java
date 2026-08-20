package com.amazonautomation.data;
import org.testng.annotations.DataProvider;

public class LoginData {
    @DataProvider(name = "loginData")
    public static Object[][] loginData(){
        return new Object[][]{
                {"tomsmith", "SuperSecretPassword!", true, ""},
                {"tomsmith", "wrongPassword", false,
                        "Your password is invalid!"},
                {"wronguser", "SuperSecretPassword!", false,
                        "Your username is invalid!"},
                {"wronguser", "wrongPassword", false,
                        "Your username is invalid!"}
        };
    }

}
