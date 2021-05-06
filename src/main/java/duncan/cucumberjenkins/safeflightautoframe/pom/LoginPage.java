package duncan.cucumberjenkins.safeflightautoframe.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {
	final WebDriver driver;

	@FindBy(id = "pageName")
	WebElement TITLE;
	@FindBy(id = "Username")
	WebElement INPUT_USERNAME;
	@FindBy(id = "Password")
	WebElement INPUT_PASSWORD;
	@FindBy(id = "btnLogin")
	WebElement BTN_LOGIN;
	@FindBy(id = "Username-error")
	WebElement VALIDATION_MESSAGE_USERNAME;
	@FindBy(id = "Password-error")
	WebElement VALIDATION_MESSAGE_PASSWORD;
	@FindBy(id = "viewBagValidationSummary")
	WebElement VALIDATION_SUMMARY;

	// static By TITLE = By.id("pageName");
	// static By INPUT_USERNAME = By.id("Username");
	// static By INPUT_PASSWORD = By.id("Password");
	// static By BTN_LOGIN = By.id("btnLogin");
	// static By VALIDATION_MESSAGE_USERNAME = By.id("Username-error");
	// static By VALIDATION_MESSAGE_PASSWORD = By.id("Password-error");
	// static By VALIDATION_SUMMARY = By.id("viewBagValidationSummary");

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		// PageFactory.initElements(driver, page);
	}

	public void goTo() {
		Driver.instance.navigate().to(URL + "Login");
	}

	public void login(String username, String password) {
		INPUT_USERNAME.sendKeys(username);
		INPUT_PASSWORD.sendKeys(password);
		BTN_LOGIN.click();
	}

	public boolean verifyIsAt() {
		if (TITLE.getText().equals("Login")) {
			return true;
		}
		return false;
	}

	public boolean verifyValidationUsernameIsRequired() {
		String message = VALIDATION_MESSAGE_USERNAME.getText();
		if (message.equals("The Username field is required.")) {
			return true;
		}
		return false;
	}

	public boolean verifyValidationPasswordIsRequired() {
		String message = VALIDATION_MESSAGE_PASSWORD.getText();
		if (message.equals("The Password field is required.")) {
			return true;
		}
		return false;
	}

	public boolean verifyValidationUsernamePasswordComboIsInvalid() {
		String message = VALIDATION_SUMMARY.getText();
		if (message.equals("The username/password combination is invalid.")) {
			return true;
		}
		return false;
	}
}