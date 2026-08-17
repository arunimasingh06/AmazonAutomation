package com.amazonautomation.basics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.JavascriptExecutor;


public class JavaScriptExecutor {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();

        driver.get("https://the-internet.herokuapp.com/login");

        JavascriptExecutor js = (JavascriptExecutor) driver;

        // 1. Find username
        WebElement username = driver.findElement(
                By.id("username")
        );

        // 2. Set username using JavaScript
        js.executeScript(
                "arguments[0].value='Arunima';",
                username
        );

        // 3. Highlight username
        js.executeScript(
                "arguments[0].style.border='3px solid red';",
                username
        );

        // 4. Get page title using JavaScript
        String title = (String) js.executeScript(
                "return document.title;"
        );

        System.out.println("Page title: " + title);

        // 5. Get browser width
        Long width = (Long) js.executeScript(
                "return window.innerWidth;"
        );

        System.out.println("Browser width: " + width);

        driver.quit();
    }
}