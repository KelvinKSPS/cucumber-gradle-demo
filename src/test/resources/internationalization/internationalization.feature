Feature: SiDi homepage internationalization
  Everybody wants to navigate at SiDi homepage in English

  Scenario: Change url to english by using the droplist
    Given I have the SiDi Website opened
    When I click to change the language to english
    Then I should reach the English Page version
    