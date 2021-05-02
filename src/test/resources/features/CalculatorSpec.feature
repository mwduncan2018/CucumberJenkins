Feature: Sample
  This is a sample bdd run to display in Jenkins.

  Background: Initialize the calculator
    Given the calculator is initialized

  @smoke
  Scenario: Calculator addition
    Given two and three are added
  	Then the result is five
  
  @smoke
  Scenario: Calculator subtraction
    Given five is subtracted from three
    Then the result is two

  @smoke
  Scenario Outline: Calculator subtraction data driven
    Given I subtract <number1> from <number2>
    Then the result is <result>

    Examples: 
      | number1  | number2 | result |
      | 12 | 10 | 2  |
      | 7  | 2  | 5  |
      | 10 | 4  | 6  |