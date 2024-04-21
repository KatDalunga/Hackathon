package stepDefinations;

import pageObjectRepository.TravelInsurance;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TravelSteps{
	WebDriver driver;
	TravelInsurance tI;
	@Given("the user is on the travel insurance page")
	public void the_user_is_on_the_travel_insurance_page() throws InterruptedException {
		tI = new TravelInsurance(Hooks.driver);
		tI.clickTravelInsurance();
	   
	   
	}
 
	@When("selects any European country")
	public void selects_any_european_country() throws InterruptedException {
		tI.clickEuropeanCountry();
		tI.clickNext();
	}
 
	@When("selects dates")
	public void selects_dates() throws InterruptedException, IOException {
		tI.clickStartDateLogo();
		tI.clickStartDate();
		tI.clickEndDate();
		tI.clickNext();
	}
 
	@When("selects No of peoples and ages")
	public void selects_no_of_peoples_and_ages() throws InterruptedException, IOException {
		tI.clickNoOfPeoples();
		tI.selectAgeOfTraveller1();
		tI.selectAgeOfTraveller2();
	}
 
	@When("click on meadical issues")
	public void click_on_meadical_issues() throws InterruptedException, IOException {
		tI.clickOnYesNo();
	}
 
	@When("enter contact details")
	public void enter_contact_details() throws InterruptedException, IOException {
		tI.enterMobileNumber();
		tI.disableWhatsappBtn();
		tI.clickViewPlans();
		
	}
	
//	@Then("user is on Travel Insurance plan for students page")
//	public void user_is_on_Travel_Insurance_plan_for_students_page() throws IOException, InterruptedException {
//		
//	}
	
	@Given("the user is on the travel insurance for students page")
	public void the_user_is_on_the_travel_insurance_for_students_page() throws IOException, InterruptedException {
		tI = new TravelInsurance(Hooks.driver);
		tI.clickStudentPlans();
	}
 
	@When("select student plan and sort option")
	public void select_student_plan_and_sort_option() throws IOException, InterruptedException {
		tI.clickTravellers();
		tI.clickTravelDurationDropDown();
		tI.selectSorts();
		tI.closeBtnForRecommendedPlan();	    
	}
 
	@Then("user should get list of three lowest insurance plans")
	public void user_should_get_list_of_three_lowest_insurance_plans() throws IOException {
		tI.insurerNameAndPlan();
	}
 
 
}