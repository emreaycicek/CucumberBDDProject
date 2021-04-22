Feature: Bein Sports Connect Australia Subscription Test Case

  Scenario: Subscription
    Given I navigate to https://connect-au.beinsports.com/en
    When I click Subscribe button
    And I register to One Month(Monthly Plan with Two Week Free Trial) package
    And I fill Create Account form with a random email
    Then I validate package price
    When I make Payment with Credit Card
    Then I expect for a total charge of 1.00 since this is a free trial package
    When I provide a test card data and confirm payment(Do not enter a real card data)
    Then I expect for a error text and finish test with success