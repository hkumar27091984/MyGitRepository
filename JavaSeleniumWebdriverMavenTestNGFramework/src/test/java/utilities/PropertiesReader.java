package utilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

import test.BlazeDemoTravelAgency;
import utilities.ExtentReportsBuilder;

public class PropertiesReader {

	// Step 1 - Create a object of class Properties class
	static Properties prop = new Properties();

	// Step 2 - Get a project path
	static String projectpath = System.getProperty("user.dir");

	public static void main(String[] args) {

		getProperties();
		//setProperties();
	}

	// How to get data from properties file
	public static void getProperties() {

		try {

			// Step 3 - Create a object of class InputStream
			InputStream input = new FileInputStream(projectpath + "\\src\\test\\java\\utilities\\config.properties");

			// Step 4 - Load Properties file
			prop.load(input);

			// Step 5 - Get values from Properties file
			String browser = prop.getProperty("browser");
			BlazeDemoTravelAgency.browserName=browser;
			ExtentReportsBuilder.browserUsed=browser;
			// Step 6 - Get values from Properties file
			System.out.println(browser);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
			System.out.println(e.getStackTrace());
		}

	}

	// How to set data to properties file
	public static void setProperties() {

		try {
			

			// Step 3 - Create a object of class OutputStream
			OutputStream output = new FileOutputStream(projectpath + "\\src\\test\\java\\utilities\\config.properties");

			// Step 4 - Set values
			prop.setProperty("Result", "PASS");

			// Step 5 - Store values in properties file
			prop.store(output, null);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
			System.out.println(e.getStackTrace());
		}

	}

}
