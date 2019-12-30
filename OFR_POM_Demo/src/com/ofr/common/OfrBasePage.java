package com.ofr.common;

import org.openqa.selenium.*;
import com.ofr.home.*;

/**
 * Class for Base functionality
 * 
 */

public class OfrBasePage {

	private WebDriver driver;

	public WebDriver getDriver() {
		return driver;
	}

	public OfrBasePage(WebDriver driver) {
		this.driver = driver;
	}

	//Sign in functionality
	public OfrSignInPage GoToHomePageAndSignIn(String username,String password) throws Exception {	
		return signInToMercuryTours(username, password);		
	}
	public OfrSignInPage signInToMercuryTours(String username, String password) {
		getSignInButton().click();
		enterUserName(username);
		enterPassword(password);
		submitButton();
		return new OfrSignInPage(driver);		
	}

	public WebElement getSignInButton() {		
		return getDriver().findElement(By.linkText(("SIGN-ON")));
	}

	public WebElement getSignOutButton() {
		return driver.findElement(By.xpath(("//a[contains(.,'SIGN-OFF')]")));		
	}

	private WebElement getUserName() {
		return driver.findElement(By.name("userName"));
	}
	public void enterUserName(String username){
		getUserName().clear();
		getUserName().sendKeys(username);	
	}	

	public WebElement getPassword() {
		return getDriver().findElement(By.name("password"));
	}

	//common in both Signin & SignUp
	public void enterPassword(String password){
		getPassword().clear();
		getPassword().sendKeys(password);	
	}

	public void submitButton(){
		goToSubmit().click();	
	}

	public WebElement goToSubmit() {
		return getDriver().findElement(By.name("login"));
	}



}
