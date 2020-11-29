package au.com.automation.stepdefinitions;

import au.com.automation.helper.Logger;
import au.com.automation.helper.WaitHelper;
import au.com.automation.pages.TestBase;
import au.com.automation.pages.securePayPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class SecurePayStepDef extends TestBase {
   securePayPage securePay = new securePayPage(driver);

    org.apache.log4j.Logger log = Logger.getLogger(SecurePayStepDef.class);

    @Given("^User navigates to Search Engine URL$")
    public void userNavigatesToApplicationURL() throws InterruptedException {
        securePay.navigateToURL();
    }

   @When("^search for the Application Name with text \"([^\"]*)\"$")
   public void searchForText(String text){
        securePay.searchForText(text);
   }

    @And("^click on SecurePay Application URL$")
    public void clickOnSecurePayAppURL() {

        securePay.clickOnWebsiteURL();
    }

    @Then("^User should navigate to Application and click on Contact Us Button$")
    public void clickOnContactUsBttn() throws Throwable {

        securePay.clickOnContactUsBtn();
    }

    @And("^fill the details in the form but won't submit$")
    public void fillDetails() {

        securePay.fillFormDetails();
    }

}
