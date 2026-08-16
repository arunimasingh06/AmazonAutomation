package com.amazonautomation.basics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTest {
    public static void main(String[] args){
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/login");
        driver.manage().window().maximize();
        WebElement username = driver.findElement(By.id("username"));
        WebElement password = driver.findElement(By.id("password"));
        WebElement loginButton = driver.findElement((By.xpath("//button[@type='submit']")));
        username.sendKeys("tomsmith");
        password.sendKeys("SuperSecretPassword!");
        loginButton.click();
        String expectedUrl =
                "https://the-internet.herokuapp.com/secure";
        String actualUrl =
                driver.getCurrentUrl();
        System.out.println("Expected URL: " + expectedUrl);
        System.out.println("Actual URL: " + actualUrl);
        if(expectedUrl.equals(actualUrl)) {
            System.out.println("Login Test Passed");
        } else {
            System.out.println("Login Test Failed");
        }
        WebElement message =
                driver.findElement(By.id("flash"));

        if(message.getText().contains("You logged into a secure area!")) {
            System.out.println("Success message verified");
        } else {
            System.out.println("Success message verification failed");
        }

        //driver.quit();
    }
}
