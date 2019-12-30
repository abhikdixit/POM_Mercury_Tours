
package com.ofr.util;

import java.io.*;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.testng.*;

import com.ofr.common.OfrBasePage;


/**
 * Life cycle of each test. test execution will start from this class
 * @author Abhi
 */
public  class TestLifecycleRule extends OfrBasePage {
	public TestLifecycleRule(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	private WebDriver driver;
	String filePath = "D:\\SCREENSHOTS";
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("***** Test Success *****");
	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub

	}

	public void onTestFailure(ITestResult result) {
		System.out.println("***** Error "+result.getName()+" test has failed *****");
		String methodName=result.getName().toString().trim();
		takeScreenShot(methodName);

	}
	public void takeScreenShot(String methodName) {
		//get the driver		
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		//The below method will save the screen shot in d drive with test method name 
		try {
			FileUtils.copyFile(scrFile, new File(filePath+methodName+".png"));
			System.out.println("***Placed screen shot in "+filePath+" ***");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub

	}


	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub

	}


	public void onFinish(ITestContext context) {		// TODO Auto-generated method stub

	}

}