package com.amazonautomation.tests;

import com.amazonautomation.base.BaseTest;
import com.amazonautomation.pages.LoginPage;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.amazonautomation.data.LoginData;
import com.amazonautomation.base.BaseTest;

import java.time.Duration;

public class LoginDataDrivenTest extends BaseTest {
    LoginPage loginPage;

    @BeforeMethod
    public void createPageObject() {
        loginPage = new LoginPage(driver);
    }

    @DataProvider(name="loginData")
    public Object[][] loginData(){
        return new Object[][]{
                {"tomsmith", "SuperSecretPassword!",true," "},
                {"tomsmith", "wrongPassword",false, "Your password is invalid!"},
                {"wronguser", "SuperSecretPassword!", false, "Your username is invalid!"},
                {"wronguser", "wrongPassword", false, "Your username is invalid!"}

        };
    }
    @Test(dataProvider = "loginData", dataProviderClass = LoginData.class)
    public void loginTest(String username, String password,
                          boolean expectedSuccess) {
        loginPage.login(username, password);
        if (expectedSuccess) {
            Assert.assertEquals(
                    driver.getCurrentUrl(),
                    "https://www.saucedemo.com/inventory.html"
            );
        } else {
            Assert.assertTrue(
                    driver.getCurrentUrl().contains("saucedemo.com")
            );
        }

        System.out.println(
                "Username: " + username +
                        " | Password: " + password
        );
    }

}
