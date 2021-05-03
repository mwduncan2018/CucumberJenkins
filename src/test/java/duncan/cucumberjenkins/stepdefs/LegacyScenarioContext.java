package duncan.cucumberjenkins.stepdefs;

import java.util.HashMap;
import java.util.Map;

/*
 * This is a wrapper around a HashMap
 * I am not sure why they decided to use it in the demo.
 * They did add an ENUM for the key, which I am not using.
 * But, there is still no good reason I see for no simply using the HashMap class.
 */
public class LegacyScenarioContext {
	private Map<String, Object> scenarioContext;

	public LegacyScenarioContext() {
		scenarioContext = new HashMap<String, Object>();
	}

	public void setContext(String key, Object value) {
		scenarioContext.put(key, value);
	}

	public Object getContext(String key) {
		return scenarioContext.get(key);
	}

	public Boolean contains(String key) {
		return scenarioContext.containsKey(key);
	}
}
