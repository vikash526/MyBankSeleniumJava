package com.mybank.testcase;

import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;

import org.apache.logging.log4j.Logger;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	com.mybank.utilities.readConfig readConfig = new com.mybank.utilities.readConfig();
	
	String baseUrl = readConfig.getBaseUrl();
	String browser = readConfig.getBrowser();
	
	String user = readConfig.user();
	String password = readConfig.password();

//	public String user = readConfig.user();

	public static WebDriver driver;
	public static Logger logger;

	@BeforeClass
	public void setup() throws IOException {
		// launch browser
		switch (browser.toLowerCase()) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;

		case "msedge":
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			break;

		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;
		default:
			driver = null;
			break;
		}

//		maximize screen
		driver.manage().window().maximize();
//		implicit wait of 5 sec
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

//		logger setup
		logger = LogManager.getLogger("MyBank");
		
		driver.get(baseUrl);
		URL url = new URL("https://demo.guru99.com/v3/index.php");
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		connection.addRequestProperty("User-Agent", "Mozilla/4.76");
		connection.setRequestMethod("GET");
		logger.info("url opened");
	}

	@AfterClass
	public void teardown() {
		// TODO Auto-generated method stub
		driver.close();
		driver.quit();
	}

	// user method to capture screen shot
	public void captureScreenShot(WebDriver driver, String testName) throws IOException {
		
		// step1: convert webdriver object to TakesScreenshot interface
		TakesScreenshot screenshot = ((TakesScreenshot) driver);

		// step2: call getScreenshotAs method to create image file
		File src = screenshot.getScreenshotAs(OutputType.FILE);

		File dest = new File(System.getProperty("user.dir") + "//Screenshots//" + testName + ".png");

		// step3: copy image file to destination
		FileUtils.copyFile(src, dest);
	}
}
