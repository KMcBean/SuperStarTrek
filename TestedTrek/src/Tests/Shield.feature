Feature: Shields Up
  Scenario: Default Shield at Game Start
    Given Start of game
    When Game initialized
    Then Shield Down
  Scenario: Raise Shield
    Given Shield is down
    And Shield is not damaged
    And Shield has energy greater than 0
    When Raise Shield
    Then Shield is up


