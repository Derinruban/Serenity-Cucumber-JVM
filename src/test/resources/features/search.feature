Feature: Sample

#  @ui @pageobject
#  Scenario Outline: Should be able to search for a product from the input box
#    Given I am viewing the Etsy landing page
#    When I search for a <product> from the input box using the Search Button
#    Then the <product> results should be displayed
#
#  Examples:
#    |product |
#    |craft   |
#    |dresses |

#
  @ui
  Scenario Outline: Should be able to search for a product from the drop-down menu
    Given I am viewing the Etsy landing page
    When I search for a <product> from the drop-down menu
    Then the <product> results should be displayed

    Examples:
    |product  |
    |headbands|
    |dresses  |

#  @ui @wip
#  Scenario: Should be able to search for a product from the icons


