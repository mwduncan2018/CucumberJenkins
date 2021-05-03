package duncan.cucumberjenkins.safeflightautoframe.pom;

import org.openqa.selenium.By;

public class DeleteWatchListEntryPage {

	public static boolean verifyIsAt(String webdriver) throws Exception {
		String actualPageName = Driver.getInstance(webdriver).findElement(By.id("pageName")).getText();
		if (actualPageName.equals("Delete Watch List Entry Page")) {
			return true;
		}
		return false;		
	}

	public static void deleteEntry(String webdriver) throws Exception {
		Driver.getInstance(webdriver).findElement(By.id("btnDelete")).click();
	}

}
