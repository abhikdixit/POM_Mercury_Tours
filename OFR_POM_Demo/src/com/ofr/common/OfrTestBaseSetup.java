package com.ofr.common;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class OfrTestBaseSetup {

	private WebDriver driver;
	static String driverPath = "D:\\F Drive\\Selenium Training Data\\workspace\\OFR_POM_Demo\\";
	String filePath = "D:\\F Drive\\Selenium Training Data\\workspace\\OFR_POM_Demo\\Screenshots";
	public WebDriver getDriver() {
		return driver;
	}

	private void setDriver(String browserType, String appURL) {
		switch (browserType) {
		case "chrome":
			driver = initChromeDriver(appURL);
			break;
		case "firefox":
			driver = initFirefoxDriver(appURL);
			break;
		default:
			System.out.println("browser : " + browserType
					+ " is invalid, Launching Firefox as browser of choice..");
			driver = initFirefoxDriver(appURL);
		}
	}

	private static WebDriver initChromeDriver(String appURL) {
		System.out.println("Launching google chrome with new profile..");
		System.setProperty("webdriver.chrome.driver", driverPath+ "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to(appURL);
		return driver;
	}

	private static WebDriver initFirefoxDriver(String appURL) {
		System.out.println("Launching Firefox browser..");
		System.setProperty("webdriver.gecko.driver", driverPath+ "geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.navigate().to(appURL);
		return driver;
	}

	@Parameters({ "browserType", "appURL" })
	@BeforeClass
	public void initializeTestBaseSetup(String browserType, String appURL) {
		try {
			setDriver(browserType, appURL);

		} catch (Exception e) {
			System.out.println("Error....." + e.getStackTrace());
		}
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}
	// It will execute after every test execution 
	@AfterMethod
	public void tearDown(ITestResult result){

		// Here will compare if test is failing then only it will enter into if condition
		if(ITestResult.FAILURE==result.getStatus()){
			try {
				// Create refernce of TakesScreenshot
				TakesScreenshot ts=(TakesScreenshot)driver;

				// Call method to capture screenshot
				File source=ts.getScreenshotAs(OutputType.FILE);

				// Copy files to specific location here it will save all screenshot in our project home directory and
				// result.getName() will return name of test case so that screenshot name will be same
				if (ensureScreenshotDirectoryExists()){
				}
				FileUtils.copyFile(source, new File(filePath +"/"+result.getName()+"_"+System.currentTimeMillis() + ".png"));

				System.out.println("Screenshot taken @ "+filePath +"\\"+result.getName()+"_"+System.currentTimeMillis() + ".png");
			} 
			catch (Exception e){	
				System.out.println("Exception while taking screenshot "+e.getMessage());
			} 
		}
		// close application
		driver.quit();
	}
	private boolean ensureScreenshotDirectoryExists() {
		File parentDir = new File(getScreenshotDirParent());
		return ((parentDir.canWrite()) || (parentDir.mkdirs()));
	}

	protected String getScreenshotDirParent() {
		return filePath;
	}
}