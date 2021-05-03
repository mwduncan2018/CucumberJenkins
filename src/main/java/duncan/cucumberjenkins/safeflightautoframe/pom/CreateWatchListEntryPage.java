package duncan.cucumberjenkins.safeflightautoframe.pom;

import org.openqa.selenium.By;

public class CreateWatchListEntryPage extends BasePage {

	static By TITLE = By.id("pageName");

	static By INPUT_BOUNTY = By.id("Bounty");
	static By INPUT_FIRST_NAME = By.id("FirstName");
	static By INPUT_LAST_NAME = By.id("LastName");
	static By BTN_CREATE = By.id("btnCreate");

	public static void goTo(String webdriver) {
		Driver.getInstance(webdriver).navigate().to(URL + "WatchList/Create");
	}

	public static boolean verifyIsAt(String webdriver) {
		if (Driver.getInstance(webdriver).findElement(TITLE).getText().equals("Create Watch List Entry")) {
			return true;
		}
		return false;
	}

	public static void createWatchListEntry(String webdriver, String firstName, String lastName, String bounty) {
		goTo(webdriver);
		Driver.getInstance(webdriver).findElement(INPUT_BOUNTY).sendKeys(bounty);
		Driver.getInstance(webdriver).findElement(INPUT_FIRST_NAME).sendKeys(firstName);
		Driver.getInstance(webdriver).findElement(INPUT_LAST_NAME).sendKeys(lastName);
		Driver.getInstance(webdriver).findElement(BTN_CREATE).click();
	}

}
