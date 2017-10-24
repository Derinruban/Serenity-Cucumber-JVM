Feature: Etsy UI samples

  @ui @pageobject
  Scenario Outline: Should be able to search for a product from the input box
    Given I am viewing the Etsy landing page
    When I search for a <product> from the input box using the Search Button
    Then the <product> search results should be displayed

  Examples:
    |product |
    |craft   |
    |dresses |


  @ui @pageobject
  Scenario Outline: Should be able to select a product from the drop-down menu
    Given I am viewing the Etsy landing page
    When I select a <menu> and a <category> and a <product> from the drop-down menu
    Then the <product> content results should be displayed

    Examples:
    |menu                   |category   |product  |
    |Jewellery & Accessories|Accessories|Headbands|
    |Clothing & Shoes       |Men        | Shirts  |

  @ui @pageobject
  Scenario Outline: Should be able to select an item via Category icons
    Given I am viewing the Etsy landing page
    When I select the <type> category icon
    Then the <type> content results should be displayed

    Examples:
      |type  |
      |Clothing |
      |Weddings |


  @ui @pageobject
  Scenario: Should be able to subscribe for email newsletter
    Given I am viewing the Etsy landing page
    When I submit a valid email addess for newsletter subscribtion
    Then I should see a confirmation message like Great! We've sent you an email to confirm your subscription.

  @ui @pageobject
  Scenario Outline: Should be able to see email validation messages for newsletter subscription
    Given I am viewing the Etsy landing page
    When I submit an <invalid> email addess for newsletter subscribtion
    Then I should see an email validation message like <error>

   Examples:
    |invalid    |  error                                 |
    |derin@com  |  Please enter a valid email address.   |
    |derin.com  |  Please enter a valid email address.   |
