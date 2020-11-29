package au.com.automation.pageObjects;

import au.com.automation.helper.WaitHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class securePayObjects {
    private static WebElement element = null;
    WaitHelper waitHelper;

    public static WebElement searchBar(WebDriver driver) {
        element = driver.findElement(By.xpath("//input[@type='text']"));
        return element;
    }
    public static WebElement selectWebsite(WebDriver driver) {
        element = driver.findElement(By.xpath("//*[@class='iUh30 Zu0yb tjvcx' and text()='www.securepay.com.au']"));
        return element;
    }
    public static WebElement clickContactUs(WebDriver driver) {
        element = driver.findElement(By.xpath("//*[@id='icon-chevron-right' and span='Contact us']"));
        return element;
    }
    public static WebElement firstName(WebDriver driver) {
        element = driver.findElement(By.xpath("//input[@name='firstName']"));
        return element;
    }
    public static WebElement lastName(WebDriver driver) {
        element = driver.findElement(By.xpath("//input[@name='lastName']"));
        return element;
    }
    public static WebElement email(WebDriver driver) {
        element = driver.findElement(By.xpath("//input[@name='email']"));
        return element;
    }
    public static WebElement phone(WebDriver driver) {
        element = driver.findElement(By.xpath("//input[@name='phone']"));
        return element;
    }
    public static WebElement company(WebDriver driver) {
        element = driver.findElement(By.xpath("//input[@name='company']"));
        return element;
    }
    public static WebElement website(WebDriver driver) {
        element = driver.findElement(By.xpath("//input[@name='website']"));
        return element;
    }
    public static WebElement amount(WebDriver driver) {
        element = driver.findElement(By.xpath("//select[@name='amount']"));
        return element;
    }
    public static WebElement message(WebDriver driver) {
        element = driver.findElement(By.xpath("//textarea[@name='message']"));
        return element;
    }
    public static WebElement checkExistingCustomer(WebDriver driver) {
        element = driver.findElement(By.xpath("//span[text()='Are you an existing Australia Post customer?']"));
        return element;
    }
}
