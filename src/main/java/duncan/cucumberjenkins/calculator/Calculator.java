package duncan.cucumberjenkins.calculator;

public class Calculator {
	Integer result;
	
	public Calculator() {
	}

	public Integer getResult() {
		return result;
	}

	public void add(Integer x, Integer y) {
		result = x + y;
	}

	public void subtract(Integer x, Integer y) {
		result = x - y;
	}

	public void multiply(Integer x, Integer y) {
		result = x * y;
	}

}
