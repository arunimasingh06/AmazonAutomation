package com.amazonautomation.data;

import org.testng.annotations.DataProvider;

import java.io.IOException;

public class LoginData {

    @DataProvider(name = "loginData")
    public static Object[][] loginData() throws IOException {

        return ExcelReader.getExcelData();
    }
}