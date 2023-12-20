Feature: Login with valid Credentials

  Scenario: Login with valid Credentials
    Given Opne Chorme Browser
    And Open URL "https://www.demo.guru99.com/v4"
    When Login ID Login Password
    And Click on Submit
    Then Redirect to Bankpage
    And Click on New Customer
    Then fill details and submit
