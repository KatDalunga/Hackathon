package pageObjectRepository;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import userDefinedLibraries.ExcelUtils;
import userDefinedLibraries.LoggerClass;

public class HealthInsurance {
	LoggerClass logger=new LoggerClass();
	WebDriver driver;
	ExcelUtils excelUtils = new ExcelUtils();
	String file2 = System.getProperty("user.dir") + "\\testdata\\PolicyBazaar_Outputs.xlsx";
	
	// constructor 
	public HealthInsurance(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//Location of required elements on the BeCognizant Page.
	@FindBy (xpath="//a[normalize-space()='Insurance Products']")
	WebElement txt_InsuranceProducts;
	
	@FindBy (xpath="//div[contains(@class,'ruby-row')]//div[3]//ul/li//span")
	List<WebElement> txt_HealthInsMenuItems;
	
	public void goToInsuranceProducts() throws InterruptedException {
		
		logger.log.info("Moving to Insurance Product Dropdown");
		Actions act = new Actions(driver);
		act.moveToElement(txt_InsuranceProducts).perform();
		Thread.sleep(2000);
	}
	
	public void getHealthInsMenuItemsList() throws IOException {
		System.out.println();
		logger.log.info("Printing All the Insurance in Health Insurance Menu ");
		for(int i = 2; i<txt_HealthInsMenuItems.size();i++) {
			System.out.println(txt_HealthInsMenuItems.get(i).getText());
			excelUtils.setCellData(file2, "Sheet1", i, 2, txt_HealthInsMenuItems.get(i).getText());
		}
		
	}
		

}