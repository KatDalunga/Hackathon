package testRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
@CucumberOptions(
	features= {".//FeatureFiles"},
		glue="stepDefinations" ,
		plugin= {"pretty", "html:reports/CucumberReport.html",
			"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
		dryRun=!true,
        monochrome=true,
        publish=true,
        //tags="@Smoke"
        tags="@Regression"
        
        )

public class TravelTestRunner extends AbstractTestNGCucumberTests {
	}
