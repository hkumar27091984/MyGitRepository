package test;

import org.testng.annotations.Test;

import utilities.Log4j;
import utilities.PropertiesReader;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BlazeDemoTravelAgency {

	private static WebDriver driver = null;
	public static String browserName = null;

	@Test
	public void openWebsite() throws InterruptedException {

		driver.get("https://blazedemo.com/");
		Thread.sleep(5000); // Let the user actually see something!
		Log4j.info("Website is Opened on the browser");

	}

	@BeforeClass
	public void browserSetupTest() {
		String projectpath = System.getProperty("user.dir");
		PropertiesReader.getProperties();
		if (browserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					projectpath + "\\src\\test\\resources\\drivers\\chromedriver.exe");
			driver = new ChromeDriver();
		} else if (browserName.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver",
					projectpath + "\\src\\test\\resources\\drivers\\geckodriver.exe");
			driver = new FirefoxDriver();
		}

	}

	@AfterClass
	public void tearDownTest() {
		driver.close();
		driver.quit();
		System.out.println("Test completed successfully");
		PropertiesReader.setProperties();
	}

}
