package com.amazonautomation.basics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class openInternet {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/dropdown");
        driver.manage().window().maximize();
        WebElement dropdown= driver.findElement(By.id("dropdown"));
        Select select = new Select(dropdown);
        select.selectByVisibleText("Option 1");
        System.out.println(dropdown.getText());
        System.out.println(select.getFirstSelectedOption().getText());


    }
}
