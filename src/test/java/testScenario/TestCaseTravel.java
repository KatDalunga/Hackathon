package testScenario;

import java.io.IOException;
import org.testng.annotations.Test;

import pageObjectRepository.TravelInsurance;
import userDefinedLibraries.DriverSetup;




public class TestCaseTravel extends DriverSetup{
	TravelInsurance tI;
	
	@Test(priority = 0,groups={"smoke","regression"})
	public void clickTravelInsurance() throws InterruptedException {
		tI = new TravelInsurance(driver);
		tI.clickTravelInsurance();
		tI.clickEuropeanCountry();
		tI.clickNext();
	}
	
	@Test(priority = 1,groups={"smoke","regression"})
	public void clickStartDate() throws InterruptedException, IOException {
		
		tI.clickStartDateLogo();
		tI.clickStartDate();
		tI.clickEndDate();
		tI.clickNext();	
	}
	
	@Test(priority = 2,groups={"smoke","regression"})
	public void selectAges() throws InterruptedException, IOException {
		tI.clickNoOfPeoples();
		tI.selectAgeOfTraveller1();
		tI.selectAgeOfTraveller2();
		tI.clickOnYesNo();	
	}
	
	@Test(priority = 3,groups={"smoke","regression"})
	public void enterContactDetais() throws InterruptedException, IOException {
		tI.enterMobileNumber();
		tI.disableWhatsappBtn();
		tI.clickViewPlans();
	}
	
	@Test(priority = 4,groups={"regression"})
	public void enterStudentPlans() throws InterruptedException, IOException {
		tI.clickStudentPlans();
		tI.clickTravellers();
		tI.clickTravelDurationDropDown();
	}
	
	@Test(priority = 5,groups={"regression"})
	public void selectSorts() throws InterruptedException, IOException {
		tI.selectSorts();
		tI.closeBtnForRecommendedPlan();
	}
	
	@Test(priority = 6,groups={"regression"})
	public void insurerNameAndPlanPrice() throws InterruptedException, IOException {
		tI.insurerNameAndPlan();
	}
	
}