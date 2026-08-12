package com.amazonautomation.basics;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.Keys;


public class mouseHover {
    public static void main (String[] args){
        WebDriver driver=new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/hovers");
        driver.manage().window().maximize();
        WebElement user= driver.findElement(
                By.xpath("(//div[@class='figure'])[1]")
        );
        Actions actions=new Actions(driver);
        actions.moveToElement(user).perform();
        WebElement user1=driver.findElement(By.xpath("(//div[@class='figure'])[1]//h5"));
        System.out.println(user1.getText());

    }
}
