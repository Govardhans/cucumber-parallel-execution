Feature: View contents

  Scenario: view new video
    When user open "https://www.youtube.com/watch?v=WG4zk1MGmTU&ab_channel=EuropemadheMarathiFamily"
    Then wait for "11" mins
