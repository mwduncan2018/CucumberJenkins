package duncan.cucumberjenkins.safeflightautoframe.pom;

import org.openqa.selenium.By;

public class DestinationsPage extends BasePage {

	static By TITLE = By.id("pageName");

	static By NEW_YORK_CAROUSEL = By.id("NewYorkCarousel");
	static By LONDON_CAROUSEL = By.id("LondonCarousel");
	static By DENVER_CAROUSEL = By.id("DenverCarousel");

	public static void goTo(String webdriver) {
		Driver.getInstance(webdriver).navigate().to(URL + "Destinations");
	}

	public static void goToDenverCarouselImage(String webdriver) {
		Driver.getInstance(webdriver).findElement(DENVER_CAROUSEL).click();
		try {
			Thread.sleep(750);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static void goToNewYorkCarouselImage(String webdriver) {
		Driver.getInstance(webdriver).findElement(NEW_YORK_CAROUSEL).click();
		try {
			Thread.sleep(750);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static void goToLondonCarouselImage(String webdriver) {
		Driver.getInstance(webdriver).findElement(LONDON_CAROUSEL).click();
		try {
			Thread.sleep(750);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static boolean verifyIsAt(String webdriver) {
		if (Driver.getInstance(webdriver).findElement(TITLE).getText().equals("Destinations")) {
			return true;
		}
		return false;
	}

}
