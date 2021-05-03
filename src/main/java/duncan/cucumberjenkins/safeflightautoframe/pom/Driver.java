package duncan.cucumberjenkins.safeflightautoframe.pom;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Driver {
	private static Map<String, WebDriver> driverMap = new HashMap<>();
	private static String GECKODRIVER_PATH = "D:\\Development Tools\\Selenium Drivers\\geckodriver-v0.24.0-win64\\geckodriver.exe";
	private static Dimension dimension = new Dimension(1920, 1080);
	private static Integer driverCount = 0;
	public static WebDriver legacyInstance = null;

	{
		System.setProperty("webdriver.gecko.driver", GECKODRIVER_PATH);
	}
	
	public static String createInstance() {
		driverCount++;
		String key = String.valueOf(driverCount);
		System.out.println(".....................KEY => " + key);
		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(15000, TimeUnit.MILLISECONDS);
		driver.manage().window().setSize(dimension);
		driverMap.put(key, driver);
		return key;
	}
	
	public static String createInstance(String key) {
		System.out.println(".....................KEY => " + key);
		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(15000, TimeUnit.MILLISECONDS);
		driver.manage().window().setSize(dimension);
		driverMap.put(key, driver);
		return key;
	}
	
	public static WebDriver getInstance(String key) {
		return driverMap.get(key);
	}
	
	public static void closeAll() {
		driverMap.entrySet().forEach(x -> x.getValue().close());
	}
}
