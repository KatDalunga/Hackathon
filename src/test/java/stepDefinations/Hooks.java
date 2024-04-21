package stepDefinations;

import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.time.Duration;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Properties;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
 
import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;
import userDefinedLibraries.LoggerClass;
 
public class Hooks {
	public static LoggerClass logger;
	public static WebDriver driver;
	public static Properties p;
	public static String br;
 
    @BeforeAll
	public static void setup() throws IOException{
    	logger=new LoggerClass();
		logger.log.info("Loading the config properties file");
		//Loading Properties File
		FileReader file = new FileReader(".//src/test/resources/config.properties");
		p = new Properties();
		p.load(file);
		
		br=p.getProperty("browser");
		//Grid
		if(p.getProperty("execution_env").equalsIgnoreCase("remote")){
			logger.log.info("Starting Execution in Remote Envirnoment .........");
			DesiredCapabilities capabilites = new DesiredCapabilities();
			switch(br.toLowerCase()) {
			case "chrome" : capabilites.setBrowserName("chrome"); break;
			case "edge" : capabilites.setBrowserName("MicrosoftEdge"); break;
			default: System.out.println("No matchingg broswer...");
			}
			driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capabilites);
		}
		else if(p.getProperty("execution_env").equalsIgnoreCase("local"))
		{
			logger.log.info("Starting Execution in local envirnoment.......");
		if (br.equalsIgnoreCase("chrome")) {
			
			logger.log.info("==========================================");
			logger.log.info("Opening Url in Chrome Browser");
			logger.log.info("==========================================");
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--disable-notifications");
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver(options);
		}
		if (br.equalsIgnoreCase("edge")) {
			logger.log.info("==========================================");
			logger.log.info("Opening Url in Edge Browser");
			logger.log.info("==========================================");
			WebDriverManager.edgedriver().setup();
			EdgeOptions options = new EdgeOptions();
			options.addArguments("--start-maximized");
			options.addArguments("--disable-notifications");
			Map<String, Object> prefs = new LinkedHashMap<>();
			prefs.put("user_experience_metrics.personalization_data_consent_enabled", Boolean.valueOf(true));
			options.setExperimentalOption("prefs", prefs);
			driver = new EdgeDriver(options);
		}
		}
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
		driver.manage().window().maximize();
		driver.get(p.getProperty("appURL"));
		logger.log.info("Url Opened successfully in......");
	}
    
    @AfterAll
	public static void tearDown() {
		driver.quit();
		logger.log.info("Closed browser successfully");
		logger.log.info("==========================================");
	}
    @AfterStep
    public static void addScreenshot(Scenario scenario) {
        	TakesScreenshot ts=(TakesScreenshot) driver;
        	byte[] screenshot=ts.getScreenshotAs(OutputType.BYTES);
        	scenario.attach(screenshot, "image/png",scenario.getName());
        	            
        }

}