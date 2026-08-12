package com.amazonautomation.basics;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DoubleClick {
    public static void main(String[] args){
        WebDriver driver= new ChromeDriver();
        driver.get("https://api.jquery.com/dblclick/");
        driver.manage().window().maximize();
        WebElement iframe = driver.findElement(
                By.cssSelector("#example-1 iframe")
        );
        driver.switchTo().frame(iframe);
        WebElement box = driver.findElement(
                By.xpath("//div")
        );
        Actions action=new Actions(driver);
        action.doubleClick(box).perform();

        System.out.println("Double click performed");

        driver.switchTo().defaultContent();
        System.out.println("back to main page");

    }
}
