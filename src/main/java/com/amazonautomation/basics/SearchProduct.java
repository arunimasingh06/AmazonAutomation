package com.amazonautomation.basics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;

public class SearchProduct {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();

        driver.get("https://www.amazon.in");

        driver.manage().window().maximize();
        WebDriverWait wait =
                new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement searchBox= wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.id("twotabsearchtextbox")
                ));
        searchBox.sendKeys("Laptop");

        searchBox.submit();

        System.out.println("Search Submitted");

        WebElement firstProduct = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.xpath("(//div[@data-component-type='s-search-result']//a[h2])[1]")
                )
        );
        String originalWindow = driver.getWindowHandle();
        firstProduct.click();

        System.out.println("Product Found");


        for (String window : driver.getWindowHandles()) {
            if (!window.equals(originalWindow)) {
                driver.switchTo().window(window);
                break;
            }
        }

        WebElement title = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.id("productTitle")
                )
        );
        WebElement price = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.cssSelector("span.a-price-whole")
                )
        );

        System.out.println(title.getText());
        System.out.println(price.getText());

    }
}