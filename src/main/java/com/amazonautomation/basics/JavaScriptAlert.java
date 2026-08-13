package com.amazonautomation.basics;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.Alert;


public class JavaScriptAlert {
    public static void main(String[] args){
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/javascript_alerts?utm_source=chatgpt.com");
        driver.manage().window().maximize();
        WebElement alertButton = driver.findElement(By.xpath("//button[text()='Click for JS Prompt']"));

        alertButton.click();

        Alert alert = driver.switchTo().alert();
        System.out.println(alert.getText());
        alert.sendKeys("Hello");
        alert.accept();
        System.out.println("Prompt Accepted");
    }
}
