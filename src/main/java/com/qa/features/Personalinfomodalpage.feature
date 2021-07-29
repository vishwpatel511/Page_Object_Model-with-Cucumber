Feature: user enters the number of fields and enters the payment information and he/she should be able to get the order confirmation.

Scenario: required textboxes and order confirmation test

Given user had chosen the product.
Then user enters the name, country, city, card number, month, year
And user hits the purchase button
Then user gets the order confirmation with the order details