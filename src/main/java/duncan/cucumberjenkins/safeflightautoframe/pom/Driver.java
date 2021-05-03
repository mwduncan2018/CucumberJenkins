package duncan.cucumberjenkins.safeflightautoframe.pom;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Driver {
	private static Map<String, WebDriver> webdrivers = new HashMap<>();
	private static String GECKODRIVER_PATH = "D:\\Development Tools\\Selenium Drivers\\geckodriver-v0.24.0-win64\\geckodriver.exe";
	private static Dimension dimension = new Dimension(1920, 1080);
	public static WebDriver legacyInstance = null;

	public static String createInstance() {
		WebDriver instance = new FirefoxDriver(); 
	}
	
	public static void initialize() {
		System.setProperty("webdriver.gecko.driver", GECKODRIVER_PATH);

		if (legacyInstance != null) {
			close();
		}
		if (legacyInstance == null) {
			legacyInstance = new FirefoxDriver();
		}
		legacyInstance.manage().timeouts().implicitlyWait(15000, TimeUnit.MILLISECONDS);
		legacyInstance.manage().window().setSize(dimension);
	}

	public static void close() {
		legacyInstance.quit();
		legacyInstance = null;
	}
}
