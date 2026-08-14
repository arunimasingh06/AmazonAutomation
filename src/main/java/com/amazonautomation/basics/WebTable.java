package com.amazonautomation.basics;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import java.util.List;

public class WebTable {
    public static void main(String[] args){
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/tables");
        driver.manage().window().maximize();
        List<WebElement> rows = driver.findElements(
                By.xpath("//table[@id='table1']/tbody/tr")
        );
        System.out.println("Number of rows: " + rows.size());
        double max=0;
        for(WebElement row: rows){
            System.out.println(row.getText());
            List<WebElement> cells = row.findElements(
                    By.tagName("td")
            );
            for(WebElement cell : cells){
                System.out.print(cell.getText()+'|');
            }
            System.out.println();
            String due= cells.get(3).getText();
            double amount = Double.parseDouble(
                    due.replace("$","")
            );
            if(amount>max){
                max=amount;
            }
        }
        WebElement row= driver.findElement(By.xpath("//table[@id='table1']//tr[td[text()='Smith']]"));
        String email = row.findElement(
                By.xpath("./td[3]")
        ).getText();
        System.out.println(max);
        System.out.println("Smith's Email: " + email);
    }
}
