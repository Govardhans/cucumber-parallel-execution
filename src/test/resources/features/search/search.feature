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

  @youtube
  Scenario: view new video
    When user open "https://www.youtube.com/watch?v=WG4zk1MGmTU&ab_channel=EuropemadheMarathiFamily"
    And increase speed to 2X
    Then wait for "11" mins