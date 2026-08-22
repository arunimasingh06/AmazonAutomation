package com.amazonautomation.base;

import com.amazonautomation.utils.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import com.amazonautomation.utils.ConfigReader;
import java.time.Duration;

public class BaseTest {

    protected WebDriver driver;

    @BeforeMethod
    public void setUp() {
        String browser = ConfigReader.getProperty("browser");

        driver = DriverFactory.createDriver(browser);

        driver.manage().window().maximize();

        int timeout = Integer.parseInt(
                ConfigReader.getProperty("timeout")
        );

        driver.manage().timeouts()
                .pageLoadTimeout(Duration.ofSeconds(timeout));

        String url = ConfigReader.getProperty("url");

        driver.get(url);
    }

    @AfterMethod
    public void tearDown() {

        if (driver != null) {
            driver.quit();
        }
    }
}