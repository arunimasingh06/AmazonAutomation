package com.amazonautomation.basics;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
public class implicitWait {
    public static void main(String[] args){
        WebDriver driver = new ChromeDriver();
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        WebElement remove = driver.findElement(By.xpath("//button[text()='Remove']"));
        remove.click();
        WebDriverWait wait = new WebDriverWait(
                driver, Duration.ofSeconds(10)
        );
        WebElement button = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Add']"))
        );
        System.out.println(button.getText());

    }
}
