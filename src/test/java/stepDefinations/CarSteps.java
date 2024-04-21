package stepDefinations;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjectRepository.CarInsurance;

public class CarSteps {
	WebDriver driver;
	CarInsurance cI;
	
	@Given("User is on the policybazar website")
	public void user_is_on_the_policybazar_website() throws InterruptedException {
		cI = new CarInsurance(Hooks.driver);	
	}
 
	@When("User Click On Car Insurance")
	public void user_click_on_car_insurance() throws InterruptedException {
		cI.clickCarInsurance();
	}
	
	@When("User select on new car")
	public void User_select_on_new_car() throws InterruptedException {
		cI.clickHere_NewCar();
	}	
	
	@When("User select city and RTO")
	public void User_select_city_and_RTO() throws InterruptedException {
		cI.selCity_Rto();
	}
	
	@Then("User select car brand and variant")
	public void User_select_car_brand_and_variant () throws InterruptedException {
		cI.selCarBrand();
	}
	
	@Given("User is on contact details page")
	public void User_is_on_contact_details_page() throws IOException {
		cI = new CarInsurance(Hooks.driver);
	}
	
	@When("User Enters invalid email address")
	public void user_enters_invalid_email_address() throws IOException {
		cI.email_Send();
	}
 
	@Then("Display the Error Message")
	public void display_the_error_message() throws IOException {
		Assert.assertEquals(cI.email_ErrorMessage(), true,"Error Message is not Displayed");
		System.out.println("Error Message is Displayed");
		cI.navigateBack();
	}
 
}


