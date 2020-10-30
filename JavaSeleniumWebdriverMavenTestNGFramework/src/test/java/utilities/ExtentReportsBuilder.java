package utilities;
import utilities.PropertiesReader;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.Assert;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportsBuilder {
	
    ExtentReports extent;
	ExtentSparkReporter spark;
	ExtentTest test;
	private static WebDriver driver = null;
	public static String browserUsed = null;
	

	
	@Test
	 public void extentReportsDemo() {
		
		String projectpath = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver",
					projectpath + "\\src\\test\\resources\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.co.in");
		
		extent.createTest("extentReportsDemo");
		System.out.println(driver.getTitle());
		Assert.assertEquals(driver.getTitle(),"Google");   
	 }
	
	
	
	@BeforeSuite
	public void startExtentReports() {

		extent = new ExtentReports();
		spark = new ExtentSparkReporter(
				"F:\\Eclipse_Oxygen_WorkSpace\\JavaSeleniumWebdriverMavenTestNGFramework\\target\\ExtenHtmlReport.html");
		extent.attachReporter(spark);
		
		spark.config().setDocumentTitle("Automation Test Report");
		spark.config().setReportName("Functional Test Report");
		spark.config().setTheme(Theme.DARK);
		extent.setSystemInfo("HostName", "LocalHost");
		PropertiesReader.getProperties();
		extent.setSystemInfo("browser", "browserUsed");
		extent.setSystemInfo("OS", "Windows 10");
		extent.setSystemInfo("TesterName", "Harish Kumar");
		
	}
	
	@AfterSuite
	public void stopExtentReports() {
	extent.flush();
	}
		
}