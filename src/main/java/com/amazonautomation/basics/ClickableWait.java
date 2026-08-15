package com.amazonautomation.basics;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ClickableWait {
    public static void main (String[] args){
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(
                driver, Duration.ofSeconds(10)
        );
        WebElement button = wait.until(
                ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Remove']"))
        );
        button.click();
        System.out.println("Remove Clicked");
        WebElement addButton = wait.until(
                ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Add']"))
        );
        addButton.click();
        System.out.println("Add Clicked");


    }
}
