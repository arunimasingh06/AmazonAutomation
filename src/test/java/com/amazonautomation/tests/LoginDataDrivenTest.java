package com.amazonautomation.tests;

import com.amazonautomation.pages.LoginPage;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
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
                {"tomsmith", "SuperSecretPassword!",true},
                {"tomsmith", "wrongPassword",false},
                {"wronguser", "SuperSecretPassword!", false},
                {"wronguser", "wrongPassword", false}

        };
    }
    @Test(dataProvider = "loginData")
    public void loginTest(String username, String password,boolean expectedSucces){
        loginPage.login(username, password);
        if (expectedSucces){
            Assert.assertEquals(driver.getCurrentUrl(),"https://the-internet.herokuapp.com/secure");
        }else{
            Assert.assertTrue(
                    driver.getCurrentUrl().contains("/login")
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
