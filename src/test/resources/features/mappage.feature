
Feature: Check Map page search feature

Scenario: Check Map page search for Gold user
Given navigate to the application URL
And accept cookies
And sign in with valid credentials
When the user clicks the world map button
And  enters "london" in the where from field
And the user selects the date range and click on search button
And the user selects a random destination from the results
Then the map should zoom in to the selected destination
And user should be able to logout successfully

Scenario: Check Map page search for Bronze user
Given navigate to the application URL
And accept cookies
And sign in with Bronze user credentials
When the user clicks the world map button
And  enters "london" in the where from field
And the user selects the date range and click on search button
Then the user should get popup for membership upgrade with membership button
And on clicking membership button, user redirects to pricing page
Then user should be able to logout successfully