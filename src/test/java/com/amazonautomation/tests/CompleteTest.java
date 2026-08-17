package com.amazonautomation.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;

public class CompleteTest {

    WebDriver driver;
    WebDriverWait wait;
    @BeforeClass
    public void beforeClass() {
        System.out.println("=== Before Class ===");
    }
    @BeforeMethod
    public void setUp() {

        driver = new ChromeDriver();

        driver.manage().window().maximize();

        wait = new WebDriverWait(
                driver,
                Duration.ofSeconds(10)
        );

        driver.get("https://the-internet.herokuapp.com/login");
    }


    @Test
    public void validLoginTest() {

        WebElement username = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.id("username")
                )
        );

        username.sendKeys("tomsmith");

        driver.findElement(By.id("password"))
                .sendKeys("SuperSecretPassword!");

        driver.findElement(
                By.xpath("//button[@type='submit']")
        ).click();

        WebElement heading = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//h2")
                )
        );

        String actualHeading = heading.getText();

        Assert.assertEquals(
                actualHeading,
                "Secure Area"
        );
    }

    @AfterMethod
    public void tearDown() {

        driver.quit();
    }
    @AfterClass
    public void afterClass() {
        System.out.println("=== After Class ===");
    }
}