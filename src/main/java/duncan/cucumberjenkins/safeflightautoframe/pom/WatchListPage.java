package duncan.cucumberjenkins.safeflightautoframe.pom;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class WatchListPage extends BasePage {

	static By TITLE = By.id("pageName");
	
	public static void goTo(String webdriver) {
		Driver.getInstance(webdriver).navigate().to(URL + "WatchList");
	}

	public static boolean verifyIsAt(String webdriver) {
		if (Driver.getInstance(webdriver).findElement(TITLE).getText().equals("Create Watch List Entry")) {
			return true;
		}
		return false;
	}

	public static void deleteUserFromWatchList(String webdriver, String lastName, String firstName) throws Exception {
		goTo(webdriver);
		List<WebElement> bountyList = Driver.getInstance(webdriver).findElements(By.id("bounty"));
		List<WebElement> firstNameList = Driver.getInstance(webdriver).findElements(By.id("firstName"));
		List<WebElement> lastNameList = Driver.getInstance(webdriver).findElements(By.id("lastName"));
		List<WebElement> deleteList = Driver.getInstance(webdriver).findElements(By.linkText("Delete"));

		int index = 0;
		for (WebElement firstNameElement : firstNameList) {
			if (firstNameElement.getText().equals(firstName)) {
				if (lastNameList.get(index).getText().equals(lastName)) {
					deleteList.get(index).click();
					DeleteWatchListEntryPage.deleteEntry(webdriver);
				}
			}
			index++;
		}
	}

}
