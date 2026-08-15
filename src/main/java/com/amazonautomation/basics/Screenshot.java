package com.amazonautomation.basics;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.OutputType;
import java.io.File;
import java.nio.file.Files;

public class Screenshot {
    public static void main(String[] args) throws Exception{
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/");
        driver.manage().window().maximize();
        TakesScreenshot screenshot = (TakesScreenshot) driver;
        File source = screenshot.getScreenshotAs(OutputType.FILE);
        File destination = new File("homepage.png");
        Files.copy(source.toPath(),destination.toPath());
        System.out.println("Screenshot Captured");
        driver.quit();
    }
}
