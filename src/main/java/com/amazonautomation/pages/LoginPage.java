package com.amazonautomation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;


public class LoginPage {
    WebDriver driver;

    @FindBy(id = "username")
    WebElement username;

    @FindBy(id = "password")
    WebElement password;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement loginButton;

    @FindBy(id = "flash")
    WebElement errorMessage;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public void enterUsername(String user) {
        username.clear();
        username.sendKeys(user);
        System.out.println("Username value: " + username.getAttribute("value"));
    }

    public void enterPassword(String pass) {
        password.clear();
        password.sendKeys(pass);
        System.out.println("Password value: " + password.getAttribute("value"));
    }

    public void clickLogin() {
        System.out.println("Clicking login button...");
        loginButton.click();
    }

    public String getErrorMessage() {
        WebDriverWait wait = new WebDriverWait(
                driver,
                Duration.ofSeconds(10)
        );

        return wait.until(
                ExpectedConditions.visibilityOf(errorMessage)
        ).getText();
    }
}
