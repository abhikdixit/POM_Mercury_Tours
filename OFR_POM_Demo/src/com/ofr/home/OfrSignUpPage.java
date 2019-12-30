package com.ofr.home;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.ofr.common.OfrSeleniumPage;


public class OfrSignUpPage {
	private WebDriver driver;

	//above are sample 
	private By firstNameTextBox = By.name("firstName");
	private By lastNameTextBox = By.name("lastName");
	private By phoneTextBox = By.name("phone");
	private By emailTextBox = By.id("userName");
	public static final String USER_NAME = "ofrAutomationTest";
	public static final String USER_EMAIL_DOMAIN = "@yahoo.com";
	private By addressTextBox1= By.name("address1");
	private By addressTextBox2= By.name("address2");
	private By cityTextBox= By.name("city");
	private By stateTextBox= By.name("state");
	private By postalTextBox= By.name("postalCode");
	private By userNameTextBox= By.id("email");
	private By passwordTextBox= By.name("password");
	private By confirmPasswordTextBox= By.name("confirmPassword");
	private By submitTextBox= By.name("register");

	public OfrSignUpPage(WebDriver driver) {
		this.driver=driver;
	}

	public OfrSignUpPage clickonRegister() throws InterruptedException {
		WebElement element=driver.findElement(By.xpath(("//a[contains(.,'REGISTER')]")));
		if(element.isDisplayed()||element.isEnabled())
			element.click();
		goToCreateAccount();
		return new OfrSignUpPage(driver);
	}
	public OfrSignUpPage goToCreateAccount() throws InterruptedException{
		driver.findElement(firstNameTextBox).sendKeys("Mercury");
		driver.findElement(lastNameTextBox).sendKeys("Regestration");
		driver.findElement(phoneTextBox).sendKeys("12345678909");
		driver.findElement(emailTextBox).sendKeys(getRandomEmail());
		driver.findElement(addressTextBox1).sendKeys("BTM 2nd Stage");
		driver.findElement(addressTextBox2).sendKeys("N.S.Palya");
		driver.findElement(cityTextBox).sendKeys("Bangalore");
		driver.findElement(stateTextBox).sendKeys("Karnataka");
		driver.findElement(postalTextBox).sendKeys("560066");
		gotoCountryDropDown();
		
		driver.findElement(userNameTextBox).sendKeys("Abhinay Dixit");
		driver.findElement(passwordTextBox).sendKeys("password");
		driver.findElement(confirmPasswordTextBox).sendKeys("password");
		driver.findElement(submitTextBox).click();
		
		return new OfrSignUpPage(driver);

	}
	public String getRandomEmail() {
		System.out.println("email account created as: "+(USER_NAME + OfrSeleniumPage.randomNum(10) + USER_EMAIL_DOMAIN));
		return (USER_NAME + OfrSeleniumPage.randomNum(10) + USER_EMAIL_DOMAIN);
	}

	public void gotoCountryDropDown(){
		Select select = new Select(driver.findElement(By.name("country")));
		select.selectByVisibleText("INDIA");
	}
	public boolean verifySignInPageTitle() {
		String expectedTitle = "Register: Mercury Tours";
		return getSignInPageTitle().contains(expectedTitle);
	}
	public String getSignInPageTitle() {
		String pageTitle = driver.getTitle();
		return pageTitle;
	}

	public boolean verifySignInPageText() {
		WebElement element = driver.findElement(By.xpath(("//font[contains(text(), 'Thank you for registering.')]")));	
		String pageText = element.getText();
		String expectedPageText = "Thank you for registering.";
		return pageText.contains(expectedPageText);
	}
}


