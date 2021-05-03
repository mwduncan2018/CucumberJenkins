package duncan.cucumberjenkins.stepdefs.safeflight;

import static org.junit.jupiter.api.Assertions.assertEquals;

import duncan.cucumberjenkins.stepdefs.ScenarioContext;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.And;

public class LoginSteps {
	private ScenarioContext scenarioContext;

	public LoginSteps(ScenarioContext scenarioContext) {
		this.scenarioContext = scenarioContext;
	}

	@Given("I navigate to the login page")
	public void navigateToTheLoginPage() {

	}

	@When("I login with a blank username field and a blank password field")
	public void loginWithBlankUsernameAndBlankPassword() {

	}
	
	@Then("a validation message stating that the username field is required is displayed")
	public void validationMessageStatingUsernameFieldIsRequiredDisplayed() {
		
	}
	
	@And("a validation message stating that the password field is required is displayed")
	public void validationMessageStatingPasswordFieldIsRequiredDisplayed() {
		
	}
	
	@When("I login with a valid username field and an invalid password field")
	public void loginWithValidUsernameAndInvalidPassword() {
		
	}
	
	@Then("a validation message is displayed stating the username and password combination is invalid")
	public void validationMessageStatingUsernameAndPasswordCombinationIsInvalid() {
		
	}

	@When("I login with a valid username field and a valid password")
	public void loginWithValidUsernameAndValidPassword() {
		
	}
	
	@Then("I am redirected to the Flight List page")
	public void redirectedToFlightListPage() {
		
	}
	
}
