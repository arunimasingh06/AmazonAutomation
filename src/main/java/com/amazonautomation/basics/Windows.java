package com.amazonautomation.basics;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.Set;

public class Windows {
    public static void main ( String[] args){
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/windows");
        driver.manage().window().maximize();
        WebElement link = driver.findElement(By.xpath("//a[text()='Click Here']"));
        System.out.println(driver.getWindowHandle());
        System.out.println(driver.getWindowHandles());
        String parent = driver.getWindowHandle();
        link.click();
        Set<String> windows = driver.getWindowHandles();
        for ( String window : windows){
            if(!window.equals(parent)){
                driver.switchTo().window(window);
                break;
            }
        }

        driver.switchTo().window(parent);
        System.out.println("Current URL: " + driver.getCurrentUrl());
        System.out.println("Page Title: " + driver.getTitle());


    }
}
