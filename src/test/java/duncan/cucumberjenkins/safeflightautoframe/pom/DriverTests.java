package duncan.cucumberjenkins.safeflightautoframe.pom;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;


class DriverTests {

	@Test
	void test1() {
		Driver.createInstance();
		Driver.createInstance();
		Driver.createInstance("Stephanie");
		
		
		LoginPage.goTo("Stephanie");
		Driver.closeAll();
	}

}
