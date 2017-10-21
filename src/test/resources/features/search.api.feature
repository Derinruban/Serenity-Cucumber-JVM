Feature: Etsy API samples

  @api
  Scenario Outline: Suggestive search service returns correct search suggestions
  Given I am using the Etsy API
  When I make a suggestive search get request for <input>
  Then the response code is 200
  And the suggested results are correctly returned for <input>

  Examples:
  |input|
  |ba   |
  |de   |
  |ha   |
  |dar  |

  @api
  Scenario Outline: Shop Name service returns total count and related shops for valid entries
  Given I am using the Etsy API
  When I make a shop name request for <shop_name>
  Then the response code is 200
  And the shop name results are correctly returned for <shop_name>

  Examples:
  | shop_name |
  | dresses   |
  | halloween |

  @api
  Scenario Outline: Shop Name service returns zero count and no related shops for invalid entries
  Given I am using the Etsy API
  When I make a shop name request for <shop_name>
  Then the response code is 200
  And the shop name service returns no results for <shop_name>

  Examples:
  | shop_name |
  | %667567   |
  | 11122233  |