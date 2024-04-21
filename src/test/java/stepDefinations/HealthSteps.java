package stepDefinations;

import java.io.IOException;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pageObjectRepository.HealthInsurance;

public class HealthSteps {
	HealthInsurance hI;
	
	@Given("User Click On Health Insurance")
	public void user_click_on_health_insurance() throws InterruptedException {
		hI = new HealthInsurance(Hooks.driver);
		hI.goToInsuranceProducts();
	}
 
	@Then("Display All Health Insurance Plans")
	public void display_all_health_insurance_plans() throws IOException {
		hI.getHealthInsMenuItemsList();
	}
}
