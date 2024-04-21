package pageObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import userDefinedLibraries.ExcelUtils;
import userDefinedLibraries.LoggerClass;

import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;

public class CarInsurance {
	LoggerClass logger=new LoggerClass();
	WebDriver driver;
	Actions act; 
	ExcelUtils excelUtils = new ExcelUtils();
	String file = System.getProperty("user.dir") + "\\testdata\\PolicyBazaar_Inputs.xlsx";
	String file2 = System.getProperty("user.dir") + "\\testdata\\PolicyBazaar_Outputs.xlsx";
	  
	
	public CarInsurance(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}

	
	//Location of required elements on the CarInsurance Page.
	@FindBy (xpath="//div[@class='prd-block car']")
	WebElement txt_CarInsurance;
	
	@FindBy (xpath="//*[contains(text(),'Click here')]")
	WebElement btn_Clickhere;
	
	@FindBy (xpath="//*[contains(text(),'Pune')]")
	WebElement sel_City;
	
	@FindBy (xpath="//*[text() = 'MH12']")
	WebElement sel_Rto;
	
	@FindBy (xpath="//*[text()='TATA']")//tata 
	WebElement sel_CarBrand;
	
	@FindBy (xpath="//li[contains(text(),'Harrier')]")//car model - Harrier
	WebElement sel_CarModel;
	
	@FindBy (xpath="//*[@type='text']")
	WebElement carModelSearchBox;
	
	@FindBy (xpath = "//input[@type='text']/following-sibling::div")
	WebElement carModelFirstSearch;
	
	@FindBy (xpath = "(//*[text()='Pure (1956 cc)'])[1]")
	WebElement carVarientFirstSearch;
	
	@FindBy (xpath="//li[contains(text(),'Fearless Dark Edition AT (1956 cc)')]")//car Variant - Fearless Dark Edition AT (1956 cc)
	WebElement sel_CarVariant;
	
	@FindBy (xpath="//*[contains(text(),'mail')]/preceding-sibling::input")//Email TextBox
	WebElement txt_emailId;
	
	@FindBy (xpath="//*[contains(text(),'mail')]/preceding-sibling::input/following-sibling::div[2]")//Email TextBox Error Message
	WebElement emailId_Error;
	
	@FindBy (xpath="//*[contains(text(),'Mobile')]/preceding-sibling::input")//Phone No TextBox
	WebElement phone_No;
	
	@FindBy (xpath="//*[contains(text(),'Mobile')]/preceding-sibling::input/following-sibling::div[2]")//Email TextBox Error Message
	WebElement phone_No_Error;
	
	@FindBy (xpath="//*[@type='button']")//View Price Button
	WebElement btn_ViewPrice;
	
	@FindBy (xpath="//span[@class='slider round']")//Slider click
	WebElement slidbtn_WhatsApp;
	
	@FindBy (xpath = "//a[contains(text(),'Sign in')]")
	WebElement signIn;
	
	public void clickCarInsurance() throws InterruptedException {
		
		logger.log.info("Moving to Car Insurance Option");
		act = new Actions(driver);
		act.moveToElement(txt_CarInsurance).build().perform();
		
		txt_CarInsurance.click();
		logger.log.info("Clicked on Car Insurance Option");
		Thread.sleep(2000);
	}
	
	public void clickHere_NewCar() throws InterruptedException {
		
		act = new Actions(driver);
		act.moveToElement(btn_Clickhere).build().perform();
		btn_Clickhere.click();
		logger.log.info("Clicked on New Car Option ");
		Thread.sleep(2000);
		
	}
	
	public void selCity_Rto() throws InterruptedException {
		sel_City.click();
		logger.log.info("Selected City ");
		Thread.sleep(1000);
		sel_Rto.click();
		logger.log.info("Selected Rto");
		Thread.sleep(1000);
		
	}
	
	public void selCarBrand() throws InterruptedException {
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", sel_CarBrand);
		logger.log.info("Selected Car Brand ");
		Thread.sleep(2000);
		
		carModelSearchBox.click();
		carModelSearchBox.sendKeys("Harrier");
		Thread.sleep(1000);
		carModelFirstSearch.click();
		Thread.sleep(1000);
		carModelSearchBox.click();
		logger.log.info("Selected Car Model ");
		
		carModelSearchBox.sendKeys("Pure");
		Thread.sleep(1000);
		carVarientFirstSearch.click();
		logger.log.info("Selected Car Varient ");
		Thread.sleep(2000);
		
	}
	
	public void email_Send() throws IOException {
		String emailId = excelUtils.getCellData(file, "Sheet1", 2, 10);
		txt_emailId.sendKeys(emailId);
		logger.log.info("Sent Invalid EmailId as input");
	}
	
	public void phno_Send(String ph_no) {
		phone_No.sendKeys(ph_no);
		btn_ViewPrice.click();
		slidbtn_WhatsApp.click();
	}
	
	public boolean phno_ErrorMessage(){
		boolean error=phone_No_Error.isDisplayed();
		System.out.println("The Error Message Dispalyed is " + phone_No_Error.getText());
		return error;	
	}
	
	public boolean email_ErrorMessage() throws IOException {
		boolean error=emailId_Error.isDisplayed();
		System.out.println("The Error Message Dispalyed is " + emailId_Error.getText());
		excelUtils.setCellData(file2, "Sheet1", 2, 1, "The Error Message Dispalyed is " + emailId_Error.getText());
		logger.log.info("Captured Error message of Invalid Email");
		return error;
	}
	
	public void navigateBack() {

		while(true) {
			try {
				if (signIn.isDisplayed()) {
	                break;
	            }
			}catch (Exception e) {
				
			}
			driver.navigate().back();	
		}
	}
}