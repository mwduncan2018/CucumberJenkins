package duncan.cucumberjenkins.stepdefs.safeflight;

import static org.junit.jupiter.api.Assertions.assertEquals;

import duncan.cucumberjenkins.safeflightautoframe.pom.Driver;
import duncan.cucumberjenkins.safeflightautoframe.pom.FlightsPage;
import duncan.cucumberjenkins.safeflightautoframe.pom.LoginPage;
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
		Driver.initialize();
		LoginPage.goTo();
	}

	@When("I login with a blank username field and a blank password field")
	public void loginWithBlankUsernameAndBlankPassword() {
		LoginPage.login("", "");
	}
	
	@Then("a validation message stating that the username field is required is displayed")
	public void validationMessageStatingUsernameFieldIsRequiredDisplayed() {
		LoginPage.verifyValidationUsernameIsRequired();
	}
	
	@And("a validation message stating that the password field is required is displayed")
	public void validationMessageStatingPasswordFieldIsRequiredDisplayed() {
		LoginPage.verifyValidationPasswordIsRequired();
	}
	
	@When("I login with a valid username field and an invalid password field")
	public void loginWithValidUsernameAndInvalidPassword() {
		LoginPage.login("mduncan", "invalidPassword");
	}
	
	@Then("a validation message is displayed stating the username and password combination is invalid")
	public void validationMessageStatingUsernameAndPasswordCombinationIsInvalid() {
		LoginPage.verifyValidationUsernamePasswordComboIsInvalid();
	}

	@When("I login with a valid username field and a valid password")
	public void loginWithValidUsernameAndValidPassword() {
		LoginPage.login("mduncan", "password");
	}
	
	@Then("I am redirected to the Flight List page")
	public void redirectedToFlightListPage() {
		assertEquals(true, FlightsPage.verifyIsAt());
	}
	
}
