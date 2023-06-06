package org.example;
import org.junit.Assert;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Main{
    public static void main(String[] args) {
        // Specify the path to the chromedriver executable
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\me\\Downloads\\chromedriver_win32\\chromedriver.exe");

        // Create a new instance of the Chrome driver
        WebDriver driver = new ChromeDriver();

        // Use the driver to navigate to a URL and interact with elements
        driver.get("https://www.amazon.in");
        System.out.println("Page title: " + driver.getTitle());
        var login_icon=  driver.findElement(By.xpath("//*[@id=\"nav-link-accountList-nav-line-1\"]"));
        login_icon.click();


        WebElement mobile_number = driver.findElement(By.xpath("//*[@id=\"ap_email\"]"));
        mobile_number.click();
        mobile_number.sendKeys("9536424457");


        WebElement continue_button = driver.findElement(By.xpath("//*[@id=\"continue\"]"));
        continue_button.click();

        WebElement password = driver.findElement(By.xpath("//*[@id=\"ap_password\"]"));
        password.click();
        password.sendKeys("gjwegdqme");


        WebElement signin = driver.findElement(By.xpath("//*[@id=\"signInSubmit\"]"));
        signin.click();

        WebElement error = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[2]/div/div[1]/div/div/div/div/ul/li/span"));
        String expected_error_message = error.getText();
        String actual_error ="Your password is incorrect";

        Assert.assertEquals(expected_error_message,actual_error );

        if (expected_error_message == actual_error) {
            System.out.println("Assertion passed: Expected value is equal to actual value");
        } else {
            System.out.println("Assertion failed: Expected value is not equal to actual value");
        }




        // Close the browser
        //driver.quit();
    }
}

