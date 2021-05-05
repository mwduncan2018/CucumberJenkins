package duncan.cucumberjenkins.safeflightautoframe.pom;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

class SeleniumTest {
	private static String GECKODRIVER_PATH = "D:\\Development Tools\\Selenium Drivers\\geckodriver-v0.24.0-win64\\geckodriver.exe";
	private static Dimension dimension = new Dimension(1200, 1000);

	@Test
	void seleniumTest1() {
		System.setProperty("webdriver.gecko.driver", GECKODRIVER_PATH);
		WebDriver x = new FirefoxDriver();
		x.manage().timeouts().implicitlyWait(15000, TimeUnit.MILLISECONDS);
		x.manage().window().setSize(dimension);
		x.navigate().to("https://www.pnc.com/en/personal-banking.html");
		x.findElement(By.className("cmp-button__text")).click();
		x.findElement(By.name("userId")).sendKeys("exitonly");
		x.findElement(By.name("password")).sendKeys("Bootstrap12#$");
		x.findElement(By.className("cmp-login__submit")).click();
		x.findElement(By.id("answer")).sendKeys("Baltimore");
		x.findElement(By.id("continue")).click();
	}

}
