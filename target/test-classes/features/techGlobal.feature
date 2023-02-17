Feature: TechGlobal Pagination Functionality

  Background:
    Given user is on "https://techglobal-training.netlify.app/"
    When user moves to Practices header dropdown
    And user clicks on Frontend Testing header dropdown option
    Then user should be navigated to "https://techglobal-training.netlify.app/frontend"
    And user clicks on "Pagination" card
    Then user should be navigated to "https://techglobal-training.netlify.app/frontend/pagination"

  Scenario: Validate the main content of the Pagination Page
    And user should see "Pagination" heading
    And user should see "World City Populations 2022" heading
    And user should see "What are the most populated cities in the world? Here is a list of the top five most populated cities in the world:" paragraph

  Scenario: Validate the Pagination Page Next/Previous buttons
    And user should see "Previous" button is disabled
    And user should see "Next" button is enabled
    When user clicks on Next button
    Then user should see "Previous" button is enabled
    When user clicks on Next button till it becomes disabled
    Then user should see "Previous" button is enabled
    And user should see "Next" button is disabled


  Scenario: Validate the Pagination Page cities content
    And user should see Tokyo city with info below and an image
      |City: Tokyo| Country: Japan| Population: 37,435,191|
    When user clicks on Next button
    And user should see Delhi city with info below and an image
      |City: Delhi| Country: India| Population: 29,399,141|
    When user clicks on Next button
    And user should see Shangai city with info below and an image
      |City: Shangai| Country: China| Population: 26,317,104|
    When user clicks on Next button
    And user should see Sao Paulo city with info below and an image
      |City: Sao Paulo| Country: Brasil| Population: 21,846,507|
    When user clicks on Next button
    And user should see Mexico City city with info below and an image
      |City: Mexico City| Country: Mexico| Population: 21,671,908|

#  Scenario Outline: Validate the Pagination Page cities content
#    And user should see "<city>" city with info below and an image
#      |City: Tokyo| Country: Japan| Population: 37,435,191|
#    When user clicks on Next button
#    And user should see "<city>" city with info below and an image
#      |City: Delhi| Country: India| Population: 29,399,141|
#    When user clicks on Next button
#    And user should see "<city>" city with info below and an image
#      |City: Shangai| Country: China| Population: 26,317,104|
#    When user clicks on Next button
#    And user should see "<city>" city with info below and an image
#      |City: Sao Paulo| Country: Brasil| Population: 21,846,507|
#    When user clicks on Next button
#    And user should see "<city>" city with info below and an image
#      |City: Mexico City| Country: Mexico| Population: 21,671,908|

#  Scenario Outline: Validate the Pagination Page cities content
#    And user should see "<city>" city with info below and an image
#      | City: Tokyo       | Country: Japan  | Population: 37,435,191 |
#      | City: Delhi       | Country: India  | Population: 29,399,141 |
#      | City: Shangai     | Country: China  | Population: 26,317,104 |
#      | City: Sao Paulo   | Country: Brasil | Population: 21,846,507 |
#      | City: Mexico City | Country: Mexico | Population: 21,671,908 |
#    When user clicks on Next button
#
#    Examples:
#      | city        |
#      | Tokyo       |
#      | Delhi       |
#      | Shangai     |
#      | Sao Paulo   |
#      | Mexico City |
