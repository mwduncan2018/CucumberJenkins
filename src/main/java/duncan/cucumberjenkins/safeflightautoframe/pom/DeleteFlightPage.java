package duncan.cucumberjenkins.safeflightautoframe.pom;

import org.openqa.selenium.By;

public class DeleteFlightPage extends BasePage {

	public static boolean verifyIsAt(String webdriver) throws Exception {
		String actualPageName = Driver.getInstance(webdriver).findElement(By.id("pageName")).getText();
		if (actualPageName.equals("Delete Flight")) {
			return true;
		}
		return false;
	}

	public static void deleteFlight(String webdriver) throws Exception {
		Driver.getInstance(webdriver).findElement(By.id("btnDelete")).click();
	}

}