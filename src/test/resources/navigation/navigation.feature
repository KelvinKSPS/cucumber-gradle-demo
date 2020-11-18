Feature: SiDi homepage navigation
  Everybody wants to navigate at SiDi homepage

  Scenario: Reach Jobs Page from SiDi homepage
    Given I have the SiDi Website opened
    When I click on jobs button
    Then I should be reach SiDi Jobs Page
    
   Scenario Outline: Reach all subpages from SiDi homepage
    Given I have the SiDi Website opened
    When I click on <subItem> inside the menu
    Then I should reach <subItem> Page
    
    Examples:
    | subItem 	|
    | nos				|
    | solucoes	|
    | cases			|
    | blog			|
    | noticias  |
    | contato   |