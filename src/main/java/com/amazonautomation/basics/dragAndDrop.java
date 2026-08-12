package com.amazonautomation.basics;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class dragAndDrop {
    public static void main(String[] args){
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/drag_and_drop");
        WebElement source= driver.findElement(By.xpath("//div[@id='column-a']"));
        WebElement destination = driver.findElement(By.xpath("//div[@id='column-b']"));
        Actions action=new Actions(driver);
        action.dragAndDrop(source,destination).perform();

        System.out.println("Drag and Drop completed");
    }
}
