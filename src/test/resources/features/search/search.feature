@ui
Feature: Search for content

  Scenario: Search for information
    Given launch browser
    And navigate to home page
    Then verify page title is "Google"
    When I enter a search term "cucumber"
