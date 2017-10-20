Feature: Sample

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
  Scenario Outline: Should be able to search for a product from the drop-down menu
    Given I am viewing the Etsy landing page
    When I search for <product> from the drop-down menu
    Then the <product> content results should be displayed

    Examples:
    |product  |
    |Headbands|
    |Handbags |

#  @ui @wip
#  Scenario: Should be able to search for a product from the icons


