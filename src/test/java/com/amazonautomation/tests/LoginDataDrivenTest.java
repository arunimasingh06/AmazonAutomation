package com.amazonautomation.tests;

import com.amazonautomation.pages.LoginPage;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

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
                {"tomsmith", "SuperSecretPassword!"},
                {"tomsmith", "wrongPassword"},
                {"wronguser", "SuperSecretPassword!"},
                {"wronguser", "wrongPassword"}

        };
    }
    @Test(dataProvider = "loginData")
    public void loginTest(String username, String password){
        loginPage.login(username, password);
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
