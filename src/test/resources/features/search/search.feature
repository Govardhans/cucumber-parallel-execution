@ui
Feature: Search for content

  Scenario Outline: Search for information
    Given launch browser
    And navigate to home page
    Then verify page title is "<PageTitle>"
    When I enter a search term "<SearchText>"
    Examples:
      | PageTitle | SearchText |
      | Google    | cucumber   |