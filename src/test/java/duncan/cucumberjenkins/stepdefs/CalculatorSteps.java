package duncan.cucumberjenkins.stepdefs;

import static org.junit.jupiter.api.Assertions.assertEquals;

import duncan.cucumberjenkins.Calculator;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.And;

public class CalculatorSteps {
	Calculator calculator = null;

	@Given("the calculator is initialized")
	public void theCalculatorIsInitialized() {
		calculator = new Calculator();
	}

	@Given("two and three are added")
	public void twoAndThreeAreAdded() {
		calculator.add(2, 3);
	}

	@Then("the result is five")
	public void theResultIsFive() {
		assertEquals(5, calculator.getResult());
	}

	@Given("five is subtracted from three")
	public void fiveIsSubtractedFromThree() {
		calculator.subtract(5, 3);
	}

	@Then("the result is two")
	public void theResultIsTwo() {
		assertEquals(2, calculator.getResult());
	}

	@Given("I subtract {int} from {int}")
	public void isSubtractedFrom(int numberA, int numberB) {
		calculator.subtract(numberA, numberB);
	}

	@Then("the result is {int}")
	public void theResultIs(int result) {
		assertEquals(result, calculator.getResult());
	}
}
