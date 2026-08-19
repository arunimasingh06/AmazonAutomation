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
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class LoginTest {
    WebDriver driver;
    LoginPage loginPage;
    @BeforeMethod
    public void setUp(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(
                "https://the-internet.herokuapp.com/login"
        );

        loginPage = new LoginPage(driver);
    }

    @Test
    public void validLogin() {

        loginPage.login("tomsmith", "SuperSecretPassword!");

        WebDriverWait wait = new WebDriverWait(
                driver,
                Duration.ofSeconds(10)
        );

        wait.until(ExpectedConditions.urlContains("/secure"));

        Assert.assertEquals(
                driver.getCurrentUrl(),
                "https://the-internet.herokuapp.com/secure"
        );
    }
    @Test
    public void invalidLogin() {

        loginPage.login("tomsmith", "wrongPassword");

        String actualMessage =
                loginPage.getErrorMessage();

        Assert.assertTrue(
                actualMessage.contains(
                        "Your password is invalid!"
                )
        );
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}