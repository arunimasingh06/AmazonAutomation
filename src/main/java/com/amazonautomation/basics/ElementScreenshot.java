package com.amazonautomation.basics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeDriver;
import java.io.File;
import java.nio.file.Files;

public class ElementScreenshot {
    public static void main(String[] args) throws Exception{
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/login");
        driver.manage().window().maximize();

        WebElement loginBox = driver.findElement(By.id("login"));

        File source = loginBox.getScreenshotAs(OutputType.FILE);

        File destination = new File("loginBox.png");

        Files.copy(source.toPath(), destination.toPath());

        System.out.println("Element Screenshot Captured");

        driver.quit();
    }
}
