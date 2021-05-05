package duncan.cucumberjenkins.stepdefs.calcdemo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import duncan.cucumberjenkins.calculator.Calculator;
import duncan.cucumberjenkins.stepdefs.ScenarioContext;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class AdditionSteps {
	private ScenarioContext scenarioContext;

	public AdditionSteps(ScenarioContext scenarioContext) {
		this.scenarioContext = scenarioContext;
	}

	@Given("the calculator is initialized")
	public void theCalculatorIsInitialized() {
		scenarioContext.getContextBag().put("Calculator", new Calculator());
		scenarioContext.increment();
		System.out.println(scenarioContext.getCount());
	}

	@Given("two and three are added")
	public void twoAndThreeAreAdded() {
		((Calculator) scenarioContext.getContextBag().get("Calculator")).add(2,3);
		scenarioContext.increment();
		System.out.println(scenarioContext.getCount());
	}

	@Then("the result is five")
	public void theResultIsFive() {
		Integer actual = ((Calculator) scenarioContext.getContextBag().get("Calculator")).getResult();
		assertEquals(5, actual);
		scenarioContext.increment();
		System.out.println(scenarioContext.getCount());
	}

}
