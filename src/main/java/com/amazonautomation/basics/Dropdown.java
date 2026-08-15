package com.amazonautomation.basics;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.Select;
import java.util.List;

public class Dropdown {
    public static void main (String[] args){
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/dropdown");
        driver.manage().window().maximize();
        WebElement dropdown = driver.findElement(By.id("dropdown"));
        Select select = new Select(dropdown);
        select.selectByContainsVisibleText("Option 1");
        System.out.println(select.getFirstSelectedOption().getText());
        select.selectByValue("2");
        System.out.println(select.getFirstSelectedOption().getText());
        select.selectByIndex(1);
        System.out.println(select.getFirstSelectedOption().getText());

        List<WebElement> options = select.getOptions();
        for(WebElement option : options ){
            System.out.println(option.getText());
        }
        WebElement selected = select.getFirstSelectedOption();
        System.out.println(selected.getText());

        System.out.println("Multiple Selections:"+ select.isMultiple());

    }
}
