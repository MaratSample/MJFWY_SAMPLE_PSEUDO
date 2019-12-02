@login
Feature: Verify Login functionality

  Scenario: Validate login function with invalid credentials
    Given User at login page
    When User enters invalid username and password
      | username       | password |
      | 1234@gmail.com | password |
      | alfa@gmail.com | login123 |
    Then error message displayed
    And fields with invalid credentials are highlighted


