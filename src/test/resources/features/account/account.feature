@ui
Feature: Search for content


  Scenario: Search for information
    Given launch browser
    And navigate to home page
    Then verify page title is "Google"

  @sanity
  Scenario:  test yml config
    Given yaml config read