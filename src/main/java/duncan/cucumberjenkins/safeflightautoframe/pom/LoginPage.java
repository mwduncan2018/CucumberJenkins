package duncan.cucumberjenkins.safeflightautoframe.pom;

import org.openqa.selenium.By;

public class LoginPage extends BasePage {

	static By TITLE = By.id("pageName");

	static By INPUT_USERNAME = By.id("Username");
	static By INPUT_PASSWORD = By.id("Password");
	static By BTN_LOGIN = By.id("btnLogin");

	static By VALIDATION_MESSAGE_USERNAME = By.id("Username-error");
	static By VALIDATION_MESSAGE_PASSWORD = By.id("Password-error");
	static By VALIDATION_SUMMARY = By.id("viewBagValidationSummary");

	public static void goTo(String webdriver) {
		Driver.getInstance(webdriver).navigate().to(URL + "Login");
	}

	public static void login(String webdriver, String username, String password) {
		Driver.getInstance(webdriver).findElement(INPUT_USERNAME).sendKeys(username);
		Driver.getInstance(webdriver).findElement(INPUT_PASSWORD).sendKeys(password);
		Driver.getInstance(webdriver).findElement(BTN_LOGIN).click();
	}

	public static boolean verifyIsAt(String webdriver) {
		if (Driver.getInstance(webdriver).findElement(TITLE).getText().equals("Login")) {
			return true;
		}
		return false;
	}

	public static boolean verifyValidationUsernameIsRequired(String webdriver) {
		String message = Driver.getInstance(webdriver).findElement(VALIDATION_MESSAGE_USERNAME).getText();
		if (message.equals("The Username field is required.")) {
			return true;
		}
		return false;
	}

	public static boolean verifyValidationPasswordIsRequired(String webdriver) {
		String message = Driver.getInstance(webdriver).findElement(VALIDATION_MESSAGE_PASSWORD).getText();
		if (message.equals("The Password field is required.")) {
			return true;
		}
		return false;
	}

	public static boolean verifyValidationUsernamePasswordComboIsInvalid(String webdriver) {
		String message = Driver.getInstance(webdriver).findElement(VALIDATION_SUMMARY).getText();
		if (message.equals("The username/password combination is invalid.")) {
			return true;
		}
		return false;
	}

}
