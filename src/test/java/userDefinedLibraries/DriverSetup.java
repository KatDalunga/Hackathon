package userDefinedLibraries;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class DriverSetup {
	LoggerClass logger;
	public static WebDriver driver;
	public static String url="https://www.policybazaar.com/";
	@Parameters({"browser"})
	@BeforeClass(alwaysRun=true)
	public void  driverInstantiate(String br) {
			
		if(br.equalsIgnoreCase("chrome")) {
			logger=new LoggerClass();
			logger.log.info("==========================================");
			logger.log.info("Opening Url in Chrome Browser");
			logger.log.info("==========================================");
			ChromeOptions options = new ChromeOptions();
			options.addArguments("disable-notifications");
			driver=new ChromeDriver(options);
			
		}else if(br.equalsIgnoreCase("edge")) {
			logger.log.info("==========================================");
			logger.log.info("Opening Url in Edge Browser");
			logger.log.info("==========================================");
			EdgeOptions options = new EdgeOptions();
			options.addArguments("disable-notifications");
			driver=new EdgeDriver(options);
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get(url);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
	
    @AfterClass(alwaysRun=true)
    public void driverTearDown() {
			driver.quit();
			logger.log.info("Closed the Browser");
			logger.log.info("==========================================");
	}
	
}