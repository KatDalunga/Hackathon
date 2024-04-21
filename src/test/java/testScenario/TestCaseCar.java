package testScenario;

import userDefinedLibraries.DriverSetup;
import pageObjectRepository.CarInsurance;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCaseCar extends DriverSetup {
	  CarInsurance cI;
	  @Test(priority = 1,groups={"smoke","regression"})
	  public void sel_NewCar_forInsurance() throws InterruptedException {
		  cI=new CarInsurance(driver);
		  cI.clickCarInsurance();
		  cI.clickHere_NewCar();
		  cI.selCity_Rto();
		  cI.selCarBrand();
      }
	  
	  @Test(priority = 2,groups={"regression"})
	  public void sendData() throws IOException{
		  cI.email_Send();
	  }
	  
	  @Test(priority = 3,groups={"regression"})
	  public void email_Capture_ErrorMessage() throws InterruptedException, IOException {
		  Assert.assertEquals(cI.email_ErrorMessage(), true,"Error Message is not Displayed");
		  System.out.println("Error Message is Displayed");
		  cI.navigateBack();
	  }
}
	
