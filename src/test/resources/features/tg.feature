
Feature: TechGlobal Pagination Functionality test

  Background:
    Given user is on "https://techglobal-training.netlify.app/"
    When user moves to Practices header dropdown
    And user clicks on Frontend Testing header dropdown option
    Then user should be navigated to "https://techglobal-training.netlify.app/frontend"
    And user clicks on "Pagination" card
    Then user should be navigated to "https://techglobal-training.netlify.app/frontend/pagination"

  Scenario: Validate the Pagination Page cities content
    Then user see cities with info below and an image and clicks on Next button
      | City: Tokyo       | Country: Japan  | Population: 37,435,191 |
      | City: Delhi       | Country: India  | Population: 29,399,141 |
      | City: Shangai     | Country: China  | Population: 26,317,104 |
      | City: Sao Paulo   | Country: Brasil | Population: 21,846,507 |
      | City: Mexico City | Country: Mexico | Population: 21,671,908 |
