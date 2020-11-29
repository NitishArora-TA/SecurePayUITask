package au.com.automation.pages;

import au.com.automation.helper.Constants;
import au.com.automation.helper.WaitHelper;
import au.com.automation.pageObjects.securePayObjects;
import org.apache.commons.lang.RandomStringUtils;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class securePayPage {
    private WebDriver driver;
    WaitHelper waitHelper;

    public securePayPage(WebDriver driver) {
        this.driver = driver;
        waitHelper = new WaitHelper(driver);

    }

    public void navigateToURL(){
        driver.get(Constants.mainUrl);
    }

    public void searchForText(String textValue){
        securePayObjects.searchBar(driver).sendKeys(textValue);
        enterKeyboardFunction();
    }

    public void clickOnWebsiteURL(){
        securePayObjects.selectWebsite(driver).click();
    }

    public void clickOnContactUsBtn(){
        waitForPageLoad();
        scrollToPageEnd();
        securePayObjects.clickContactUs(driver).click();
    }


    public void fillFormDetails(){
        String firstName = getRandomInteger(8);
        String lastName = getRandomInteger(6);
        String email = firstName + "." + lastName + "@1secmail.com";
        String phone = getRandomInteger(10);
        String company = getRandomString(10);
        String website = "www." +company+ ".com.au";
        String message = getRandomString(25);

        securePayObjects.firstName(driver).sendKeys(firstName);
        securePayObjects.lastName(driver).sendKeys(lastName);
        securePayObjects.email(driver).sendKeys(email);
        securePayObjects.phone(driver).sendKeys(phone);
        securePayObjects.company(driver).sendKeys(company);
        securePayObjects.website(driver).sendKeys(website);
        securePayObjects.amount(driver).sendKeys("Less than $100,000");
        securePayObjects.message(driver).sendKeys(message);
        securePayObjects.checkExistingCustomer(driver).click();
    }

    public void waitForPageLoad(){
        ExpectedCondition<Boolean> pageLoadCondition = new ExpectedCondition<Boolean>() {
          public Boolean apply(WebDriver driverPage){
              return ((JavascriptExecutor)driverPage).executeScript("return document.readyState", new Object[0].equals("complete");
          }
        };
        WebDriverWait wait = new WebDriverWait(driver,60L);
        wait.until(pageLoadCondition);
    }
    public String getRandomString(int count){
        boolean randomStringGenerated = false;
        String generatedString;
        do {
            generatedString = RandomStringUtils.randomAlphabetic(count);
            Pattern pattern = Pattern.compile("^.*(.)\\1\\1.*$");
            Matcher matcher = pattern.matcher(generatedString.toLowerCase());
            if (!matcher.find()) {
                randomStringGenerated = true;
            }
        }while(!randomStringGenerated);
        return generatedString;
        }

    public String getRandomInteger(int length){
        String intPool = "123456789";
        StringBuilder sb = new StringBuilder(length);
        for(int i=0; i < length; i++) {
            int index = (int)(intPool.length() * Math.random());

            sb.append(intPool.charAt(index));
        }
        return sb.toString();
    }

    public void scrollToPageEnd()
    {
        Actions builder = new Actions(driver);
        builder.sendKeys(new CharSequence[]{Keys.END}).perform();

    }
    public void enterKeyboardFunction(){
        Actions action = new Actions(driver);
        action.sendKeys(new CharSequence[]{Keys.ENTER}).build().perform();
    }

}



