package duncan.cucumberjenkins.safeflightautoframe.pom;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import duncan.cucumberjenkins.safeflightautoframe.testmodels.Flight;

public class FlightsPage extends BasePage {

	static By TITLE = By.id("pageName");

	private static List<WebElement> watchListColumn;
	private static List<WebElement> firstNameColumn;
	private static List<WebElement> lastNameColumn;
	private static List<WebElement> departureAirportColumn;
	private static List<WebElement> departureTimeColumn;
	private static List<WebElement> arrivalAirportColumn;
	private static List<WebElement> arrivalTimeColumn;
	private static List<WebElement> editColumn;
	private static List<WebElement> detailsColumn;
	private static List<WebElement> deleteColumn;

	private static void refreshTable(String webdriver) {
		watchListColumn = Driver.getInstance(webdriver).findElements(By.cssSelector("#watchList > input"));
		firstNameColumn = Driver.getInstance(webdriver).findElements(By.id("firstName"));
		lastNameColumn = Driver.getInstance(webdriver).findElements(By.id("lastName"));
		departureAirportColumn = Driver.getInstance(webdriver).findElements(By.id("departureAirport"));
		departureTimeColumn = Driver.getInstance(webdriver).findElements(By.id("departureTime"));
		arrivalAirportColumn = Driver.getInstance(webdriver).findElements(By.id("arrivalAirport"));
		arrivalTimeColumn = Driver.getInstance(webdriver).findElements(By.id("arrivalTime"));
		editColumn = Driver.getInstance(webdriver).findElements(By.linkText("Edit"));
		detailsColumn = Driver.getInstance(webdriver).findElements(By.linkText("Details"));
		deleteColumn = Driver.getInstance(webdriver).findElements(By.linkText("Delete"));
	}

	private static Integer indexOf(String lastName, String firstName) {
		int index = 0;
		for (WebElement firstNameElement : firstNameColumn) {
			String temp = firstNameElement.getText();
			if (firstNameElement.getText().equals(firstName)) {
				String other = lastNameColumn.get(index).getText();
				if (lastNameColumn.get(index).getText().equals(lastName)) {
					return index;
				}
			}
			index++;
		}
		return -1;
	}

	public static void goTo(String webdriver) {
		Driver.getInstance(webdriver).navigate().to(URL + "Flights");
	}

	public static boolean verifyIsAt(String webdriver) {
		if (Driver.getInstance(webdriver).findElement(TITLE).getText().equals("Flight List")) {
			return true;
		}
		return false;
	}

	public static boolean verifyFlightIsDisplayed(String webdriver, Flight flight) {
		goTo(webdriver);
		refreshTable(webdriver);
		int index = indexOf(flight.getLastName(), flight.getFirstName());
		if (index >= 0) {
			if (firstNameColumn.get(index).getText().equals(flight.getFirstName())
					&& lastNameColumn.get(index).getText().equals(flight.getLastName())
					&& departureAirportColumn.get(index).getText().equals(flight.getDepartureAirport())
					&& departureTimeColumn.get(index).getText().equals(flight.getDepartureTime())
					&& arrivalAirportColumn.get(index).getText().equals(flight.getArrivalAirport())
					&& arrivalTimeColumn.get(index).getText().equals(flight.getArrivalTime())) {
				return true;
			}
		}
		return false;
	}
	
	public static void deleteFlight(String webdriver, String lastName, String firstName) throws Exception {
		goTo(webdriver);
		refreshTable(webdriver);
		int index = indexOf(lastName, firstName);
		if (index >= 0) {
			deleteColumn.get(index).click();
			DeleteFlightPage.deleteFlight(webdriver);
		}
	}

	public static boolean verifyWatchListColumnIsCheckedFor(String webdriver, String lastName, String firstName) {
		goTo(webdriver);
		refreshTable(webdriver);
		int index = indexOf(lastName, firstName);
		if (index >= 0) {
			if (watchListColumn.get(index).isSelected()) {
				return true;
			}
		}
		return false;
	}

}
