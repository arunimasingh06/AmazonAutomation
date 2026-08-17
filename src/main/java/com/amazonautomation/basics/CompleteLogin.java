package com.amazonautomation.basics;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.time.Instant;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.OutputType;
import java.io.File;
import java.nio.file.Files;
import org.openqa.selenium.chrome.ChromeOptions;

public class CompleteLogin {
    public static void main (String[] args) throws Exception{
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-features=PasswordLeakDetection");

        WebDriver driver = new ChromeDriver(options);
        driver.get("https://the-internet.herokuapp.com/login");
        driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(
                driver, Duration.ofSeconds(10)
        );
        WebElement username = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='username']"))
        );
        username.sendKeys("tomsmith");
        System.out.println("Username Entered: tomsmith");
        WebElement password = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='password']"))
        );
        password.sendKeys("SuperSecretPassword!");
        System.out.println("Password Entered: SuperSecretPassword!");
        WebElement login = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@type='submit']"))
        );
        login.click();
        System.out.println("Login CLicked");

        WebElement SecureArea = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[text()=' Secure Area']"))
        );
        String heading = SecureArea.getText();
        if(heading.contains("Secure Area")){
            System.out.println("Login test passed");
        }
        TakesScreenshot screenshot = (TakesScreenshot) driver;
        File source = screenshot.getScreenshotAs(OutputType.FILE);
        File destination = new File("screenshot.png");
        Files.copy(source.toPath(),destination.toPath());
        System.out.println("Captured Screenhot");
    }
}
