package userDefinedLibraries;

//import java.awt.Desktop;
//import java.io.File;
//import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
//import java.util.List;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReport extends DriverSetup implements ITestListener {
	public ExtentSparkReporter sparkReporter;
	public ExtentReports extent;
	public ExtentTest test;
	String repName;

	public void onStart(ITestContext testContext) {
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());// time stamp
		repName = "Test-Report-" + timeStamp + ".html";
		sparkReporter = new ExtentSparkReporter(".\\reports\\" + repName);// specify location of the report
		sparkReporter.config().setDocumentTitle("Hackathon Extent Report"); // Title of report
		sparkReporter.config().setReportName("Hakathon Report"); // name of the report
		sparkReporter.config().setTheme(Theme.DARK);
		extent = new ExtentReports();
		extent.attachReporter(sparkReporter);
		extent.setSystemInfo("Application", "Hackathon_Project");
		extent.setSystemInfo("Module", "Admin");
		extent.setSystemInfo("Sub Module", "Customers");
		extent.setSystemInfo("User Name", "Admin");
		extent.setSystemInfo("Environemnt", "QA");
		String os = testContext.getCurrentXmlTest().getParameter("os");
		extent.setSystemInfo("Operating System", os);
		String browser = testContext.getCurrentXmlTest().getParameter("browser");
		extent.setSystemInfo("Browser", browser);
		extent.setSystemInfo("Tester Name","Atul Sangolkar");
		
		
		
	}

	public void onTestSuccess(ITestResult result) {
		test = extent.createTest(result.getMethod().getMethodName());
		test.log(Status.PASS, result.getName() + " got successfully executed");
		String imgPath = ScreenShot.screenShotTC(driver, result.getName());
		test.addScreenCaptureFromPath(imgPath);
	}

	public void onTestFailure(ITestResult result) {
		test = extent.createTest(result.getTestClass().getName());
		test.log(Status.FAIL, result.getName() + " got failed");
		test.log(Status.INFO, result.getThrowable().getMessage());
		String imgPath = ScreenShot.screenShotTC(driver, result.getName());
		test.addScreenCaptureFromPath(imgPath);
	}

	public void onTestSkipped(ITestResult result) {
		test = extent.createTest(result.getMethod().getMethodName());
		test.log(Status.SKIP, result.getName() + " got skipped");
		test.log(Status.INFO, result.getThrowable().getMessage());
		String imgPath = ScreenShot.screenShotTC(driver, result.getName());
		test.addScreenCaptureFromPath(imgPath);
	}

	public void onFinish(ITestContext testContext) {
		extent.flush();
//		String pathOfExtentReport = System.getProperty("user.dir") + "\\reports\\" + repName;
//		File extentReport = new File(pathOfExtentReport);
//		try {
//			Desktop.getDesktop().browse(extentReport.toURI());
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
	}
}

