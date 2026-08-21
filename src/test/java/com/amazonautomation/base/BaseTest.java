package com.amazonautomation.base;

import com.amazonautomation.utils.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class BaseTest {

    protected WebDriver driver;

    @BeforeMethod
    public void setUp() {

        driver = DriverFactory.createDriver();

        driver.manage().window().maximize();

        driver.manage().timeouts()
                .pageLoadTimeout(Duration.ofSeconds(20));

        driver.get("https://www.saucedemo.com/");
    }

    @AfterMethod
    public void tearDown() {

        if (driver != null) {
            driver.quit();
        }
    }
}