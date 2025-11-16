@amazon
Feature: Amazon Shopping Workflows
  As an Amazon user
  I want to validate shopping workflows
  So that I can ensure reliability of core features

  @smoke @nologin
  Scenario: Add minimum quantity item from Today’s Deals
    Given I open Amazon.in
    When I click on "Today’s Deals"
    And I select the 3rd deal
    And I add the minimum required quantity of the item to the cart
    Then the cart should display the expected quantity

  @regression @nologin
  Scenario: Retrieve last displayed mobile details
    Given I open Amazon.in
    When I search for "Mobiles"
    And I scroll down to the last displayed item
    Then I should see the details of the last mobile item

  @navigation @nologin
  Scenario: Navigate to Mobiles and back
    Given I open Amazon.in
    When I navigate from the left nav to "Mobiles"
    And I select "Mobile Phones"
    And I return to the main menu
    Then I should be back at the homepage

  @smoke @login
  Scenario: Verify first item delivery date with Prime
    Given I am logged in to Amazon.in
    When I select the "Amazon Prime Delivery" checkbox
    And I view the first displayed item
    Then I should see the delivery date for that item

  @regression @login
  Scenario: Verify delivery status of an order
    Given I am logged in to Amazon.in
    When I check the delivery status of my current orders
    Then the status should be displayed correctly

  @regression @login
  Scenario: View past one year orders
    Given I am logged in to Amazon.in
    When I go to "Your Orders"
    And I filter by "Past one year"
    Then I should see all orders from the past year

  @smoke @login
  Scenario: Add and verify new payment option
    Given I am logged in to Amazon.in
    When I add a new payment option
    Then the new payment option should be listed in my account

  @smoke @login
  Scenario: Add and verify new delivery address
    Given I am logged in to Amazon.in
    When I add a new delivery address
    Then the new address should be listed in my account

  @negative @nologin
  Scenario: Search with invalid keyword
    Given I open Amazon.in
    When I search for "xyz123invalid"
    Then I should see a "No results found" message

  @negative @login
  Scenario: Fail to add incomplete delivery address
    Given I am logged in to Amazon.in
    When I attempt to add a new delivery address with missing postal code
    Then I should see an error message indicating required fields are missing

  @negative @login
  Scenario: Fail to add invalid payment option
    Given I am logged in to Amazon.in
    When I add a new payment option with an expired card
    Then I should see an error message "Card expired" and the option should not be added

  @edgecase @nologin
  Scenario: Verify empty cart
    Given I open Amazon.in
    When I navigate to the cart without adding any items
    Then the cart should display "Your cart is empty"

  @edgecase @login
  Scenario: Past one year orders with none available
    Given I am logged in to Amazon.in
    When I go to "Your Orders"
    And I filter by "Past one year"
    Then I should see a message "No orders found in this period"

  @edgecase @nologin
  Scenario: Scroll beyond available items
    Given I open Amazon.in
    When I search for "Mobiles"
    And I scroll down past the last displayed item
    Then I should see a message "No more items to display"
