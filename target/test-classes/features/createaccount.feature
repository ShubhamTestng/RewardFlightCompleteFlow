Feature: Sign-Up

  Scenario: User signs up with a new email
    Given user navigates to the bronze signup URL and accepts cookies
    And user enters a unique email address and clicks continue button
    And user enters the password and then clicks set password button
    And user enters the first name and last name
    And user clicks the sign-up button
    Then successfull signup message should be displayed

  Scenario: User signs up with an existing email
    Given user navigates to the bronze signup URL and accepts cookies
    And user enters a existing email address and clicks continue button
    Then error message should be displayed