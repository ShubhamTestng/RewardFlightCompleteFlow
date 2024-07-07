
Feature: Alert Feature

  Scenario: Create Alert in Production Environment
    Given navigate to the application URL
    And accept cookies
    And sign in with valid credentials
    When search for a destination
    And create a new alert with specified dates
    Then user should see the confirmation message
    And user should be able to logout successfully



  Scenario: Edit Alert in Production Environment
    Given navigate to the application URL
    And accept cookies
    And sign in with valid credentials
    When navigate to the list of alerts
    And edit an existing alert
    Then user should see the confirmation message for alert edited
    And user should be able to logout successfully


  Scenario: Delete Alert in Production Environment
    Given navigate to the application URL
    And accept cookies
    And sign in with valid credentials
    When navigate to the list of alerts
    And delete an existing alert
    Then user should see the confirmation message for alert deleted
    And user should be able to logout successfully


  Scenario: Check date range of 20 days for Bronze user
    Given navigate to the application URL
    And accept cookies
    And sign in with Bronze user credentials
    When search for a destination
    And clicks on No button on upgrade membership popup
    And create a new alert with more than twenty days range
    Then user should see the error message for 20 days maximum date range
    And user should be able to logout successfully


  Scenario: Check date range of 45 days for Silver user
    Given navigate to the application URL
    And accept cookies
    And sign in with Silver user credentials
    When search for a destination
    And create a new alert with more than Forty five days range
    Then user should see the error message for 45 days maximum date range
    And user should be able to logout successfully