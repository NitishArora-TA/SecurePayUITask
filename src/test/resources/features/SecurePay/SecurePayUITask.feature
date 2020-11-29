@SecurePay
Feature: Navigate to Secure Pay Application and Fill the form

  Scenario: User redirect to Application and perform the required action
    Given User navigates to Search Engine URL
    When search for the Application Name with text "SecurePay"
    And click on SecurePay Application URL
    Then User should navigate to Application and click on Contact Us Button
    And fill the details in the form but won't submit


