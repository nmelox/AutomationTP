Feature: Trabajo Practico Final Curso Automation II.

Scenario Outline: Search Book

Given I enter a <searchword>
When I press Search button 
Then Result page must be shown

Examples:

|searchword					|
|Sailor moon tomo 7 |

@OrderBook
Scenario Outline: Order result by low price

Given I sort result by <orderBy>
When I click on first element
Then Book page must be shown

Examples:

|orderBy				|
|price_low_high	|
