package duncan.cucumberjenkins.stepdefs;

import static org.junit.jupiter.api.Assertions.assertEquals;

import duncan.cucumberjenkins.calculator.Calculator;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class CalculatorSubtractionSteps {
	private ScenarioContext scenarioContext;
	
	public CalculatorSubtractionSteps(ScenarioContext scenarioContext) {
		this.scenarioContext = scenarioContext;
	}

	@Given("five is subtracted from three")
	public void fiveIsSubtractedFromThree() {
		((Calculator) scenarioContext.getContextBag().get("Calculator")).subtract(5,3);
		scenarioContext.increment();
		System.out.println(scenarioContext.getCount());
	}

	@Then("the result is two")
	public void theResultIsTwo() {
		Integer actual = ((Calculator) scenarioContext.getContextBag().get("Calculator")).getResult();
		assertEquals(2, actual);
		scenarioContext.increment();
		System.out.println(scenarioContext.getCount());
	}

	@Given("I subtract {int} from {int}")
	public void isSubtractedFrom(int numberA, int numberB) {
		((Calculator) scenarioContext.getContextBag().get("Calculator")).subtract(numberA, numberB);
		scenarioContext.increment();
		System.out.println(scenarioContext.getCount());
	}

	@Then("the result is {int}")
	public void theResultIs(int result) {
		Integer actual = ((Calculator) scenarioContext.getContextBag().get("Calculator")).getResult();
		assertEquals(result, actual);
		scenarioContext.increment();
		System.out.println(scenarioContext.getCount());
	}
}
