Feature: Initial experience
  As a user I want a helpful and simple initial
  experience with the app. I should be able to get help
  and login to an existing WordPress site.

  @valid
  Scenario: Correct login
    Given I am about to login
    When I enter valid credentials
    Then I can see posts for the sites

  @invalid_login
  Scenario: Incorrect login
    Given I am about to login
    When I enter invalid credentials
    Then I can see login page again

  @invalid_url
  Scenario: Incorrect url
    Given I am about to login
    When I enter invalid url
    Then I can see error message