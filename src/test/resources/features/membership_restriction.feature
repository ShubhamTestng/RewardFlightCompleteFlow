Feature: Membership restrictions

  Scenario: Alert date range Restrictions for Bronze user
    Given user navigates to the application URL
    Then accepts the cookies
    Then  sign in with bronze user credentials
    And  search for flights from nyc
    Then  click create alert button
    And  select a date range exceeding 20 days per leg
    Then user should see an error message
    And the create alert button should be disabled
    Then close the alert popup
    And logout from the account

  Scenario: Alert date range Restrictions for Silver user
    Given user navigates to the application URL
    Then accepts the cookies
    Then  sign in with silver user credentials
    And  search for flights from nyc
    Then  click create alert button
    And  select a date range exceeding 45 days per leg
    Then user should see an error message
    And the create alert button should be disabled
    Then close the alert popup
    And logout from the account

  Scenario: Check map page restrictions for Bronze user
    Given user navigates to the application URL
    Then accepts the cookies
    And sign in with bronze user credentials
    Then navigate to the world map page
    And search for flights from london with specific dates
    Then user should see an upgrade your membership popup
    And user should see the memberships button
    When user clicks upgrade button
    Then user should be redirected to the pricing page
    And logout from the account

  Scenario: Check one alert restriction for Bronze user
    Given user navigates to the application URL
    Then accepts the cookies
    And sign in with bronze user credentials
    And search for flights from "nyc"
    And create an alert with specific dates
    Then user should see an upgrade your membership popup
    And user should see the memberships button
    When user clicks upgrade button
    Then user should be redirected to the pricing page
    And logout from the account

  Scenario: Check five alert restriction for Silver user
    Given user navigates to the application URL
    Then accepts the cookies
    And sign in with silver user credentials
    And search for flights from "nyc"
    And create an alert with specific dates
    Then user should see an upgrade your membership popup
    And user should see the memberships button
    When user clicks upgrade button
    Then user should be redirected to the pricing page
    And logout from the account

