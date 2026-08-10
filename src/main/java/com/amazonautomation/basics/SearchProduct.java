package com.amazonautomation.basics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;
import java.util.List;

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
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//div[@data-component-type='s-search-result']")
                )
        );
        System.out.println("Search Submitted");

//        WebElement firstProduct = wait.until(
//                ExpectedConditions.elementToBeClickable(
//                        By.xpath("(//div[@data-component-type='s-search-result']//a[h2])[1]")
//                )
//        );
//        String originalWindow = driver.getWindowHandle();
//        firstProduct.click();
//
//        System.out.println("Product Found");
//
//
//        for (String window : driver.getWindowHandles()) {
//            if (!window.equals(originalWindow)) {
//                driver.switchTo().window(window);
//                break;
//            }
//        }
//        WebElement title = wait.until(
//                ExpectedConditions.visibilityOfElementLocated(
//                        By.id("productTitle")
//                )
//        );

//        List<WebElement> prices = driver.findElements(By.cssSelector("span.a-price-whole"));
//
//        System.out.println("Prices found = " + prices.size());
//
//        for (WebElement p : prices) {
//            if(p.isDisplayed()){
//                System.out.println("Visible Price:"+ p.getText());
//                break;
//            }
//        }

        List<WebElement> products=
                driver.findElements(
                        By.xpath("//div[@data-component-type='s-search-result']//h2")
                );
        List<WebElement> productPrices=
                driver.findElements(
                        By.xpath("//div[@data-component-type='s-search-result']//span[@class='a-price-whole']")
                );

        for(int i=0;i<5 && i< products.size();i++){
            System.out.println("Product: "+(i+1));
            System.out.println(products.get(i).getText());
            System.out.println("Price: "+ productPrices.get(i).getText());

        }
        System.out.println("Current URL: " + driver.getCurrentUrl());
        System.out.println("Current Page Title: " + driver.getTitle());
//
//        System.out.println("Product Title: " + title.getText());
//
//
//        System.out.println(title.getText());
        driver.quit();

    }
}