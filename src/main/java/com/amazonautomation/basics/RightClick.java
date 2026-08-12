package com.amazonautomation.basics;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class RightClick {
    public static void main (String[] args){
        WebDriver driver=new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/context_menu");
        driver.manage().window().maximize();
        WebElement box= driver.findElement(By.xpath("//div[@id='hot-spot']"));
        Actions actions=new Actions(driver);
        actions.contextClick(box).perform();


    }
}
