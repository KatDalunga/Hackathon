package testScenario;

import java.io.IOException;
import org.testng.annotations.Test;

import pageObjectRepository.HealthInsurance;
import userDefinedLibraries.DriverSetup;


public class TestCaseHealth extends DriverSetup {
	HealthInsurance hI;
	
	@Test(priority = 0,groups={"smoke","regression"})
	public void healthInsuranceMenuItems() throws InterruptedException, IOException {
		hI = new HealthInsurance(driver);
		hI.goToInsuranceProducts();
		hI.getHealthInsMenuItemsList();
	}

}


