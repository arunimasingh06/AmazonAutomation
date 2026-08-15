package com.amazonautomation.basics;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class CustomDropdown {
    public static void main(String[] args){
        WebDriver driver=new ChromeDriver();
        driver.get("url");
        WebElement dropdown = driver.findElement(By.xpath("div[@id='countryDropdown']"));
        dropdown.click();
        WebElement option = new WebDriverWait(
                driver, Duration.ofSeconds(10)
        ).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text='Japan']")
        ));
        option.click();

    }
}
