package com.amazonautomation.basics;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.time.Instant;

public class Exceptions {
    public static void main (String[] args){
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
        driver.findElement(By.id("start")).click();
//        WebElement hello = driver.findElement(By.id("finish"));
        WebDriverWait wait =
             new WebDriverWait(driver, Duration.ofSeconds(10));


        WebElement hello = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.id("finish")
                )
        );
        System.out.print(hello.getText());

    }
}
