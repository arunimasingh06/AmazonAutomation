package com.amazonautomation.tests;

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

import java.time.Duration;

public class LoginDataDrivenTest {
    WebDriver driver;
    LoginPage loginPage;

    @BeforeMethod
    public void setUp(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/login");
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
    public void loginTest(String username, String password,boolean expectedSuccess, String expectedMessage){
        loginPage.login(username, password);
        if (expectedSuccess){
            WebDriverWait wait = new WebDriverWait(
                    driver,
                    Duration.ofSeconds(10)
            );

            wait.until(
                    ExpectedConditions.urlContains("/secure")
            );

            Assert.assertEquals(
                    driver.getCurrentUrl(),
                    "https://the-internet.herokuapp.com/secure"
            );        }else {

            String actualMessage = loginPage.getErrorMessage();

            Assert.assertTrue(
                    actualMessage.contains(expectedMessage)
            );
        }

        System.out.println(
                "Username: " + username +
                        " | Password: " + password
        );
    }
    @AfterMethod
    public void tearDown() {

        driver.quit();
    }
}
