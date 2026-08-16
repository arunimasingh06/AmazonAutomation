package com.amazonautomation.basics;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class NegativeLoginTest {
    public static void main (String[] args){
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/login");
        driver.manage().window().maximize();
        WebElement username = driver.findElement(By.id("username"));
        WebElement password = driver.findElement(By.id("password"));
        WebElement loginButton = driver.findElement(By.xpath("//button[@type='submit']"));
        username.sendKeys("");
        password.sendKeys("");
        loginButton.click();
        WebElement errorMessage = driver.findElement(By.id("flash"));
        String actualMessage = errorMessage.getText();
        System.out.println(actualMessage);
        if(actualMessage.contains("Your password is invalid!")){
            System.out.println("Negative Login Test Passed");
        }else{
            System.out.println("Negative Login Test Failed");
        }
    }
}
