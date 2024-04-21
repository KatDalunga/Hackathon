package pageObjectRepository;

import java.io.IOException;
import java.util.List;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import userDefinedLibraries.ExcelUtils;
import userDefinedLibraries.LoggerClass;



public class TravelInsurance {
	LoggerClass logger=new LoggerClass();
	
	WebDriver driver;
	ExcelUtils excelUtils = new ExcelUtils();
	String file = System.getProperty("user.dir") + "\\testdata\\PolicyBazaar_Inputs.xlsx";
	String file2 = System.getProperty("user.dir") + "\\testdata\\PolicyBazaar_Outputs.xlsx";
	private static final String variable = "Germany";


	
	// constructor 
	public TravelInsurance(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//Location of required elements on the BeCognizant Page.
		@FindBy (xpath="//p[normalize-space()='Travel Insurance']")
		WebElement txt_TravelInsurance;
		
		@FindBy (xpath="//p[text()='Schengen']")
		WebElement txt_EuropeanCountries;
		
		@FindBy (xpath="//*[text()='" + variable + "']")
		WebElement txt_EuropeanCountry;
		
		@FindBy (xpath="//button[text()='Add']")
		WebElement btn_Add;
		
		@FindBy (xpath="//button[normalize-space()='Next']")
		WebElement btn_Next;
		
		@FindBy (xpath="(//input[@placeholder='dd mmmm, yyyy'])[1]")
		WebElement logo_StartDate;
		
		@FindBy (xpath="//h6[1]")
		WebElement txt_MonthYear;
		
		@FindBy (xpath="//button[@class='MuiButtonBase-root MuiIconButton-root MuiPickersArrowSwitcher-iconButton MuiIconButton-sizeSmall']")
		WebElement btn_nextMonthYear;
		
		@FindBy (xpath="(//div[@role='grid'])[1]//span[@class='MuiPickersDay-dayLabel']")
		List<WebElement> txt_Date;
		
		@FindBy (css="label[for='traveller_2']")
		WebElement btn_noOfPeople;
		
		@FindBy (xpath="//div[@id='0']")
		WebElement slct_AgeDropDown1;
		
		@FindBy (xpath="//div[@id='1']")
		WebElement slct_AgeDropDown2;
		
		@FindBy (xpath="//div[@id='optionBox_0_wrapper']//label")
		List<WebElement> list_AgeDropDown1;
		
		@FindBy (xpath="//div[@id='optionBox_1_wrapper']//label")
		List<WebElement> list_AgeDropDown2;
		
		@FindBy (css="#ped_yes")
		WebElement rbtn_Yes;
		
		@FindBy (css="#ped_no")
		WebElement rbtn_No;
		
		@FindBy (css="label[for='ped_yes_traveller_0']")
		WebElement rbtn_Yes_Trav1;
		
		@FindBy (css="label[for='ped_yes_traveller_1']")
		WebElement rbtn_Yes_Trav2;
		
		@FindBy (id="mobileNumber")
		WebElement txt_MobileNumber;
		
		@FindBy (css=".slider.round")
		WebElement slider_WhatsApp;
		
		@FindBy (xpath="//button[normalize-space()='View plans']")
		WebElement btn_ViewPlans;
		
		@FindBy (css=".text-btn")
		WebElement btn_ContWithNo;
		
		@FindBy (css="label[for='studentTrip']")
		WebElement rbtn_StudentPlans;
		
		@FindBy (css="label[for='Traveller_1']")
		WebElement rbtn_Traveller_1;
		
		@FindBy (css="label[for='Traveller_2']")
		WebElement rbtn_Traveller_2;
		
		@FindBy (id="feet")
		WebElement drpdn_TravelDuration;
		
		@FindBy (xpath="//select/option")
		List<WebElement> list_TravelDuration;
		
		@FindBy (xpath="//button[normalize-space()='Apply']")
		WebElement btn_Apply;
		
		@FindBy (css=".filter_name_heading")
		WebElement drpdn_SortBy;
		
		@FindBy (css="label[for='16_sort']")
		WebElement rbtn_Default;
		
		@FindBy (css="label[for='17_sort']")
		WebElement rbtn_LowToHigh;
		
		@FindBy (css="label[for='18_sort']")
		WebElement rbtn_HighToLow;
			
		@FindBy (css=".closeIconBtn")
		WebElement btn_CloseBtn;
		
		@FindBy (className = "quotesCard--insurerName")
		List<WebElement> txt_InsurerName;
		
		@FindBy (className = "premiumPlanPrice")
		List<WebElement> txt_PlanPrice;
		
		@FindBy (linkText ="Policybazaar")
		WebElement img_Logo;
		
	
		public void clickTravelInsurance() throws InterruptedException {
			
			txt_TravelInsurance.click();
			logger.log.info("Clicked on travel insurance option");
			Thread.sleep(4000);
		}
		
		public void clickEuropeanCountry() throws InterruptedException {
			
			txt_EuropeanCountries.click();
			logger.log.info("Clicked on European Countries");
			Thread.sleep(2000);
			JavascriptExecutor js = (JavascriptExecutor)driver;
			js.executeScript("arguments[0].click();", txt_EuropeanCountry);
			logger.log.info("Selected the "+variable+" as a destination country ");
			Thread.sleep(2000);
			btn_Add.click();
			Thread.sleep(4000);
		}
		
		public void clickNext() throws InterruptedException {
			btn_Next.click();
			logger.log.info("Clicked on Next button ");
			Thread.sleep(4000);
		}
		
		public void clickStartDateLogo() throws InterruptedException {
			logo_StartDate.click();
			Thread.sleep(3000);
		}
		
		
		public void clickStartDate() throws IOException, InterruptedException 
		{
			String monthAndYear = excelUtils.getCellData(file, "Sheet1", 2, 1);
			String date = excelUtils.getCellData(file, "Sheet1", 2, 2);
			Thread.sleep(2000);

			while(true) {
				String monYear = txt_MonthYear.getText(); 
				
				if(monYear.equals(monthAndYear)) {
					break;
				}
				btn_nextMonthYear.click();
			}
			for(WebElement dts : txt_Date) 
			{
				if(date.equals(dts.getText())) 
				{
					dts.click();
					break;
				}
			}
			logger.log.info("Selected Start date from datepicker ");
			Thread.sleep(3000);
			
		}
		
		public void clickEndDate() throws IOException, InterruptedException 
		{
			String monthAndYear = excelUtils.getCellData(file, "Sheet1", 3, 1);
			String date = excelUtils.getCellData(file, "Sheet1", 3, 2);
			Thread.sleep(2000);
			
			while(true) {
				String monYear = txt_MonthYear.getText(); 
				
				if(monYear.equals(monthAndYear)) {
					break;
				}
				btn_nextMonthYear.click();
			}
			for(WebElement dts : txt_Date) 
			{
				if(date.equals(dts.getText())) 
				{
					dts.click();
					break;
				}
			}
			logger.log.info("Selected End date from datepicker ");
			Thread.sleep(3000);	
		}
		
		public void alertHandling() {
			Alert alertWin = driver.switchTo().alert();
			alertWin.dismiss();
		}
		
		
		public void clickNoOfPeoples() throws InterruptedException {
			btn_noOfPeople.click();
			logger.log.info("Selected no of persons for Insurance plan");
			Thread.sleep(2000);
		}
		
		public void selectAgeOfTraveller1() throws IOException, InterruptedException {
			slct_AgeDropDown1.click();
			Thread.sleep(2000);
			String ageT1 = excelUtils.getCellData(file, "Sheet1", 2, 3);
			Thread.sleep(2000);
			for(WebElement ages : list_AgeDropDown1) 
			{
				if(ageT1.equals(ages.getText())) 
				{
					ages.click();
					break;
				}
			}
			logger.log.info("Selected 1st person age");
			Thread.sleep(2000);

		}
		
		public void selectAgeOfTraveller2() throws InterruptedException, IOException {
			slct_AgeDropDown2.click();
			String ageT2 = excelUtils.getCellData(file, "Sheet1", 2, 4);
			Thread.sleep(2000);
			for(WebElement ages : list_AgeDropDown2) 
			{
				if(ageT2.equals(ages.getText())) 
				{
					ages.click();
					break;
				}
			}
			logger.log.info("Selected 2nd person age");
			Thread.sleep(3000);
			btn_Next.click();
		}
		
		public void clickOnYesNo() throws InterruptedException, IOException {
			
			String YorN = excelUtils.getCellData(file, "Sheet1", 2, 5);
			String Traveller = excelUtils.getCellData(file, "Sheet1", 2, 6);
			Thread.sleep(3000);
			
			if(YorN.equalsIgnoreCase("Yes")) {
				rbtn_Yes.click();
				if(Traveller.equalsIgnoreCase("Traveller 1")) {
					rbtn_Yes_Trav1.click();
				}else if(Traveller.equalsIgnoreCase("Traveller 2")) {
					rbtn_Yes_Trav2.click();
				}else if(Traveller.equalsIgnoreCase("Both")) {
					rbtn_Yes_Trav1.click();
					rbtn_Yes_Trav2.click();
				}
				JavascriptExecutor js = (JavascriptExecutor)driver;
				js.executeScript("arguments[0].scrollIntoView();", btn_Next);
			}else {
				rbtn_No.click();
			}
			JavascriptExecutor js = (JavascriptExecutor)driver;
			js.executeScript("arguments[0].click();", btn_Next);
			logger.log.info("Selected Medical condition of the travellors");
			Thread.sleep(2000);
		}
		
		public void enterMobileNumber() throws IOException, InterruptedException {
			txt_MobileNumber.click();
			String mobNo = excelUtils.getCellData(file, "Sheet1", 2, 7);
			Thread.sleep(2000);
			txt_MobileNumber.sendKeys(mobNo);
			logger.log.info("Entered Mobile Number");
		}
		
		public void disableWhatsappBtn() throws InterruptedException {
			slider_WhatsApp.click();
			Thread.sleep(2000);
		}
		
		public void clickViewPlans() throws InterruptedException {
			btn_ViewPlans.click();
			btn_ContWithNo.click();
			logger.log.info("Clicked On ViewPlans");
			Thread.sleep(5000);
		}
		
		public void clickStudentPlans() throws InterruptedException {
			rbtn_StudentPlans.click();
			logger.log.info("Clicked On Student Plans");
			Thread.sleep(3000);
		}
		
		public void clickTravellers() throws InterruptedException {
			rbtn_Traveller_1.click();
			Thread.sleep(1000);
			rbtn_Traveller_2.click();
			Thread.sleep(3000);
			logger.log.info("Filled the Student Details");
			
		}
		
		public void clickTravelDurationDropDown() throws IOException, InterruptedException {
			drpdn_TravelDuration.click();
			Thread.sleep(2000);
			String duration = excelUtils.getCellData(file, "Sheet1", 2, 8);
			for(WebElement drpdwn : list_TravelDuration) {
				if(duration.equalsIgnoreCase(drpdwn.getText())) {
					drpdwn.click();
					break;
				}	
			}
			btn_Apply.click();
			logger.log.info("Selcted Travel Duration");
			Thread.sleep(2000);
			
		}
		
		public void selectSorts() throws IOException, InterruptedException {
			drpdn_SortBy.click();
			Thread.sleep(2000);
			String sort = excelUtils.getCellData(file, "Sheet1", 2, 9);
			if(sort.equalsIgnoreCase(rbtn_Default.getText())) {
				rbtn_Default.click();
			}else if(sort.equalsIgnoreCase(rbtn_LowToHigh.getText())) {
				rbtn_LowToHigh.click();
			}else if(sort.equalsIgnoreCase(rbtn_HighToLow.getText())) {
				rbtn_HighToLow.click();
			}
			logger.log.info("Sorted the plans");
			Thread.sleep(2000);
			
		}
		
		public void closeBtnForRecommendedPlan() throws InterruptedException {
			btn_CloseBtn.click();
			Thread.sleep(2000);
		}
		
		public void insurerNameAndPlan() throws IOException {
			for(int i=0,j=2 ; i<3 && j<5 ; i++,j++) {
				System.out.println("Insurer Name: "+txt_InsurerName.get(i).getText()+"     "
			+"Plan Price: "+txt_PlanPrice.get(i).getText());
				
			excelUtils.setCellData(file2, "Sheet1", j, 0, "Insurer Name: "+txt_InsurerName.get(i).getText()+"     "
							+"Plan Price: "+txt_PlanPrice.get(i).getText());
				
			}
			logger.log.info("Printed The 3 Lowest Plans");
			img_Logo.click();
			
		
		}
		
}