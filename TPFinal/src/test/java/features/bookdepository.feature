Feature: Trabajo Practico Final Curso Automation II.

Scenario Outline: Go To Webpage 

Given I enter a <searchword>
When I press Search button 
Then Result page must be shown

Examples:

|searchword				|
|Sailor moon vol 7|
