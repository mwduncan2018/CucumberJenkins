@LoginFeature
Feature: Login functionality and validations 3
  There should be login functionality including validations and proper redirection after a successful login.    
	
  @regression
  Scenario: Login validation for blank username and blank password
    Given I navigate to the login page
    When I login with a blank username field and a blank password field
    Then a validation message stating that the username field is required is displayed
    And a validation message stating that the password field is required is displayed
    
  @regression
  Scenario: Login validation for invalid username and password
	Given I navigate to the login page
    When I login with a valid username field and an invalid password field
	Then a validation message is displayed stating the username and password combination is invalid

  @smoke
  Scenario: Login with a valid username and valid password
	Given I navigate to the login page
    When I login with a valid username field and a valid password
	Then I am redirected to the Flight List page