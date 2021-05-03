package duncan.cucumberjenkins.safeflightautoframe.pom;

import org.openqa.selenium.By;

public class DestinationsPage extends BasePage {

	static By TITLE = By.id("pageName");

	static By NEW_YORK_CAROUSEL = By.id("NewYorkCarousel");
	static By LONDON_CAROUSEL = By.id("LondonCarousel");
	static By DENVER_CAROUSEL = By.id("DenverCarousel");

	public static void goTo() {
		Driver.instance.navigate().to(URL + "Destinations");
	}

	public static void goToDenverCarouselImage() {
		Driver.instance.findElement(DENVER_CAROUSEL).click();
		try {
			Thread.sleep(750);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static void goToNewYorkCarouselImage() {
		Driver.instance.findElement(NEW_YORK_CAROUSEL).click();
		try {
			Thread.sleep(750);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static void goToLondonCarouselImage() {
		Driver.instance.findElement(LONDON_CAROUSEL).click();
		try {
			Thread.sleep(750);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static boolean verifyIsAt() {
		if (Driver.instance.findElement(TITLE).getText().equals("Destinations")) {
			return true;
		}
		return false;
	}

}
