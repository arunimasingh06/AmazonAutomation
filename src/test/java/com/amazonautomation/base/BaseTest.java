package com.amazonautomation.base;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;

public class BaseTest {
    protected WebDriver driver;
    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(
                "https://the-internet.herokuapp.com/login"
        );
    }
    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

}
