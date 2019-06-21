Feature: Check login in application as user

  Scenario: login as user
    When User navigates to site
    Then Login page is displayed
    When User enters user`s name
    And User enters password
    And User presses 'Sign in' button
    Then Main page is displayed
    When User presses logout button
    Then Login page is displayed