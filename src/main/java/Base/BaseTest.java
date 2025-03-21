package Base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.junit.runner.notification.Failure;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest implements ITestListener {
	String browserName;
	String baseURL;
	String adminUsername;
	String adminPassword;
	String headless;
	public WebDriver driver;

	@BeforeSuite
	public WebDriver initializeDriver() throws IOException {

		Properties properties = new Properties();
		FileInputStream fileInput = new FileInputStream(
				"//home//nsaini//Desktop//Nikhil//NIkh//SeleniumFramework2//src//main//resources//Data1.properties");
		
		
		properties.load(fileInput);
		browserName = properties.getProperty("browser");
		baseURL = properties.getProperty("baseURL");
		headless = properties.getProperty("headless");

		if (browserName.equalsIgnoreCase("chrome")) {
			ChromeOptions options = new ChromeOptions();
			if (headless.equalsIgnoreCase("true")) {
				options.addArguments("headless");
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver(options);
			} else {
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver(options);
			}

		} else if (browserName.equalsIgnoreCase("Firefox")) {
			FirefoxOptions options1 = new FirefoxOptions();
			if (headless.equalsIgnoreCase("true")) {
				options1.addArguments("headless");
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
			} else {
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
			}

		} else if (browserName.equalsIgnoreCase("Edge")) {
			EdgeOptions options3 = new EdgeOptions();
			if (headless.equalsIgnoreCase("true")) {
				options3.addArguments("headless");
				WebDriverManager.edgedriver().setup();
				driver = new EdgeDriver();
			} else {
				WebDriverManager.edgedriver().setup();
				driver = new EdgeDriver();
			}
		}

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(25));
		driver.manage().window().maximize();
		return driver;
	}

	@BeforeSuite(dependsOnMethods = "initializeDriver")
	public void launchApplication() throws IOException {

		driver.get(baseURL);
	}



	@AfterMethod
	public void screenshotOnTestFailure(ITestResult result) {
		if(ITestResult.FAILURE==result.getStatus()){
			
		String ScreenshotName = "test";
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File destination = new File("/home/nsaini/Pictures/Screenshots" + ScreenshotName + ".png");
		try {
			System.out.println("Capturing the screenshot");
			FileUtils.copyFile(source, destination);
		} catch (IOException e) {

			System.out.println("Invalid destination path");
		}
		}
	}
	
	
	@AfterSuite
	public void teardown() {
		if (driver != null)
			driver.quit();
	}
	 

}
