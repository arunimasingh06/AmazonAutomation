package com.amazonautomation.tests;

import com.amazonautomation.pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.Assert;
import com.amazonautomation.base.BaseTest;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class LoginTest extends BaseTest{

    @Test
    public void validLogin() {
        LoginPage loginPage =
                new LoginPage(driver);
        loginPage.login(
                "tomsmith",
                "SuperSecretPassword!"
        );
        Assert.assertEquals(
                driver.getCurrentUrl(),
                "https://the-internet.herokuapp.com/secure"
        );
    }


}