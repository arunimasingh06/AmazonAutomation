package com.amazonautomation.basics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SearchProduct {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();

        driver.get("https://www.amazon.in");

        driver.manage().window().maximize();
        Thread.sleep(10000);

        WebElement searchBox= driver.findElement(By.xpath("//input[(@id='twotabsearchtextbox')]"));
        searchBox.sendKeys("Laptop");

        searchBox.submit();
    }
}